package vn.cwa.application.domain.service.applicant_campaign;

import vn.cwa.application.domain.repository.applicant_campaign.ApplicantExportCriteria;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Pageable;

public interface ApplicantService {
  void handlerExportCSV(ApplicantExportCriteria criteria, HttpServletResponse response, Pageable page) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, Exception;
}
