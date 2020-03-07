package vn.cwa.application.domain.service.applicant_campaign;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
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
import vn.cwa.application.domain.model.Applicant;
import vn.cwa.application.domain.model.BaseModel;
import vn.cwa.application.domain.model.Campaign;
import vn.cwa.application.domain.repository.applicant_campaign.ApplicantExportCriteria;
import vn.cwa.application.domain.repository.applicant_campaign.ApplicantRepository;
import vn.cwa.application.domain.repository.applicant_campaign.CampaignRepository;
import vn.cwa.application.domain.utils.DateFormaterUtils;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Inject
	ApplicantRepository applicantRepository;

	@Inject
	CampaignRepository campaignRepository;

	@Inject
	DateFormaterUtils dateFormaterUtils;

	final String defaultCsvFilename = "APPLICANT_%s.csv";
	final CsvPreference csvPref = new CsvPreference.Builder('"', ',', "\r\n").useQuoteMode(new AlwaysQuoteMode())
			.build();

	private void write(OutputStream os, List<? extends BaseModel> objects1, List<? extends BaseModel> objects2,
			String[] fieldMappingNames, String[] fieldMappingValues, CellProcessor[] processors) {

		try (Writer writer = new OutputStreamWriter(os, "SHIFT-JIS");
				ICsvBeanWriter beanWriter = new CsvBeanWriter(writer, csvPref)) {
			Object xxx = objects1.get(0);

			for (Object obj : objects2) {
				beanWriter.write(xxx, fieldMappingNames, processors);
				beanWriter.write(obj, fieldMappingValues, processors);
			}

			beanWriter.flush();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void handlerExportCSV(ApplicantExportCriteria criteria, HttpServletResponse response, Pageable page)
			throws IOException, IllegalArgumentException, IllegalAccessException {

		if (criteria.getPerInfor() || criteria.getNoPerInfor()) {

			List<Applicant> listApplicant = applicantRepository.getApplicantCsvByCriteria(criteria);
			Campaign cam = campaignRepository.findById(criteria.getCampaignId());

			response.setContentType("text/csv");
			response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			response.setHeader("Content-disposition", "attachment;filename="
					+ String.format(defaultCsvFilename, dateFormaterUtils.formatCsvTimestamp(new Date())));

			if (criteria.getPerInfor()) {

				List<Campaign> lstCam = Arrays.asList(cam);
				write(response.getOutputStream(), lstCam, listApplicant, mappingCamNames, mappingValues, processors);

				return;

			} else {

				Class<?> zClass = cam.getClass();
				Field[] fields = zClass.getDeclaredFields();
				String filedName = null;
				Integer index = 1;
				List<String> lstLabelNames = new ArrayList<String>();
				List<String> lstLabelValues = new ArrayList<String>();

				for (Field field : fields) {
					field.setAccessible(true);
					filedName = field.getName();
					if (filedName.equals("label" + index + "Flg")) {
						if ("0".equals(field.get(cam).toString())) {
							lstLabelNames.add("label" + index + "Name");
							lstLabelValues.add("label" + index + "Value");
						}
						index++;
					}
				}

				List<Campaign> lstCam = Arrays.asList(cam);
				List<CellProcessor> lstProcessor = new ArrayList<CellProcessor>();

				String[] arrayNames = lstLabelNames.stream().toArray(String[]::new);
				String[] arrayValues = lstLabelValues.stream().toArray(String[]::new);

				index = arrayNames.length;
				for (int i = 0; i < index; i++) {
					lstProcessor.add(new Optional());
				}

				CellProcessor[] arrProcessors = lstProcessor.stream().toArray(Optional[]::new);
				write(response.getOutputStream(), lstCam, listApplicant, arrayNames, arrayValues, arrProcessors);

			}

		} else if (criteria.getMultiplePerInfor()) {
			// loading...

		} else if (criteria.getMultipleNoPerInfor()) {
			// loading...

		}

	}

	final static String[] mappingCamNames = { "label1Name", "label2Name", "label3Name", "label4Name", "label5Name",
			"label6Name", "label7Name", "label8Name", "label9Name", "label10Name" };

	final static String[] mappingValues = { "label1Value", "label2Value", "label3Value", "label4Value", "label5Value",
			"label6Value", "label7Value", "label8Value", "label9Value", "label10Value" };

	final static CellProcessor[] processors = { new Optional(), new Optional(), new Optional(), new Optional(),
			new Optional(), new Optional(), new Optional(), new Optional(), new Optional(), new Optional() };

}
