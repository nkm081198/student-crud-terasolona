package vn.cwa.application.domain.repository.applicant_campaign;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vn.cwa.application.domain.model.Applicant;

public interface ApplicantRepository {
  List<Applicant> getApplicantCsvByCriteria(@Param("criteria") ApplicantExportCriteria criteria);
}
