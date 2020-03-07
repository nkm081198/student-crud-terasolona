package vn.cwa.application.app.csv;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.cwa.application.domain.repository.applicant_campaign.ApplicantExportCriteria;
import vn.cwa.application.domain.service.applicant_campaign.ApplicantService;

@Controller
public class ExportCSVController {

	@Inject
	ApplicantService applicantService;

//	private static final String DATE_TYPE = "yyyy/MM/dd";

	@RequestMapping(value = "downloadCSV")
	public void createForm(HttpServletResponse response, @RequestParam("campaignId") String campaignId,
			@RequestParam("case") String condition, @PageableDefault(page = 0, size = 1000) Pageable page)
			throws Exception {
		// create form model
		ApplicantExportCriteria criteria = new ApplicantExportCriteria();

		criteria.setCampaignId(campaignId);

		switch (condition) {
		case "per":
			criteria.setPerInfor(true);
			break;
		case "nper":
			criteria.setNoPerInfor(true);
			break;
		case "mper":
			criteria.setMultiplePerInfor(true);
			break;
		case "mnper":
			criteria.setMultipleNoPerInfor(true);
			break;

		default:
			break;
		}

		applicantService.handlerExportCSV(criteria, response, page);

	}

}
