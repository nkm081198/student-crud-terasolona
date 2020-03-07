package vn.cwa.application.domain.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Applicant extends BaseModel implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String id;

  private String cpId;

  private Date startDate;

  private Date endDate;

  private String label1Value;

  private String label2Value;

  private String label3Value;

  private String label4Value;

  private String label5Value;

  private String label6Value;

  private String label7Value;

  private String label8Value;

  private String label9Value;

  private String label10Value;
  
}
