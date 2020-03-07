package vn.cwa.application.domain.repository.applicant_campaign;

import org.apache.ibatis.annotations.Param;
import vn.cwa.application.domain.model.Campaign;

public interface CampaignRepository {
  Campaign findById(@Param("id") String id);
}
