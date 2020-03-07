package vn.cwa.application.domain.repository.applicant_campaign;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class ApplicantExportCriteria implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String campaignId;

  private Date startDate;

  private Date endDate;

  private Boolean perInfor = false;

  private Boolean noPerInfor = false;

  private Boolean multiplePerInfor = false;

  private Boolean multipleNoPerInfor = false;
  
  private List<String> campaignIds;
  
}
