package vn.cwa.application.domain.service.applicant_campaign;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.quote.AlwaysQuoteMode;

import lombok.extern.slf4j.Slf4j;
import vn.cwa.application.domain.model.Applicant;
import vn.cwa.application.domain.model.BaseModel;
import vn.cwa.application.domain.model.Campaign;
import vn.cwa.application.domain.repository.applicant_campaign.ApplicantExportCriteria;
import vn.cwa.application.domain.repository.applicant_campaign.ApplicantRepository;
import vn.cwa.application.domain.repository.applicant_campaign.CampaignRepository;
import vn.cwa.application.domain.utils.CsvUtils;
import vn.cwa.application.domain.utils.DateFormaterUtils;

@Service
@Slf4j
public class ApplicantServiceImpl implements ApplicantService {

	@Inject
	ApplicantRepository applicantRepository;

	@Inject
	CampaignRepository campaignRepository;

	@Inject
	DateFormaterUtils dateFormaterUtils;

	@Inject
	CsvUtils csvUtils;

	final String defaultCsvFilename = "APPLICANT_%s.csv";
	final CsvPreference csvPref = new CsvPreference.Builder('"', ',', "\r\n").useQuoteMode(new AlwaysQuoteMode())
			.build();

	@Override
	public void handlerExportCSV(ApplicantExportCriteria criteria, HttpServletResponse response, Pageable page)
			throws Exception {

		if (criteria.getPerInfor() || criteria.getNoPerInfor()) {

			List<Applicant> listApplicant = applicantRepository.getApplicantCsvByCriteria(criteria);
			Campaign cam = campaignRepository.findById(criteria.getCampaignId());

			response.setContentType("text/csv");
			response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			response.setHeader("Content-disposition", "attachment;filename="
					+ String.format(defaultCsvFilename, dateFormaterUtils.formatCsvTimestamp(new Date())));

			Field[] fields = cam.getClass().getDeclaredFields();

			List<String> lstLabelValues = new ArrayList<String>();
			String[] arrayValues = null;

			List<CellProcessor> lstProcessor = new ArrayList<CellProcessor>();
			CellProcessor[] arrProcessors = null;

			List<String> lstLabelNameValues = new ArrayList<String>();
			String[] header = null;
			
			String filedName = null;
			Integer index = 1;

			for (Field field : fields) {
				filedName = field.getName();
				if (filedName.equals("label" + index + "Flg")) {
					field.setAccessible(true);
					if (criteria.getPerInfor()) {
						addValueTolist(lstLabelValues, lstLabelNameValues, field, index, cam);
					} else {
						if ("0".equals(field.get(cam).toString())) {
							addValueTolist(lstLabelValues, lstLabelNameValues, field, index, cam);
						}
					}

					index++;
				}
			}

			arrayValues = lstLabelValues.stream().toArray(String[]::new);

			index = arrayValues.length;
			for (int i = 0; i < index; i++) {
				lstProcessor.add(new Optional());
			}
			header = lstLabelNameValues.stream().toArray(String[]::new);
			arrProcessors = lstProcessor.stream().toArray(Optional[]::new);

			csvUtils.write(response.getOutputStream(), listApplicant, header, arrayValues, arrProcessors);

		} else if (criteria.getMultiplePerInfor()) {
			// loading...

		} else if (criteria.getMultipleNoPerInfor()) {
			// loading...

		}

	}

	private void addValueTolist(List<String> lstLabelValues, List<String> lstLabelNameValues, Field field,
			Integer index, Object object)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		lstLabelValues.add("label" + index + "Value");
		field = object.getClass().getDeclaredField("label" + index + "Name");
		field.setAccessible(true);
		lstLabelNameValues.add(field.get(object).toString());

	}

}
