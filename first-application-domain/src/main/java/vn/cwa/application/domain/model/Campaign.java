package vn.cwa.application.domain.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Campaign extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String campaignNo;

	private String url;

	private String name;

	private Integer status;

	private Date startDate;

	private Date endDate;

	private Integer label1Flg;

	private String label1Name;

	private String label1Value;

	private Integer label2Flg;

	private String label2Name;

	private String label2Value;

	private Integer label3Flg;

	private String label3Name;

	private String label3Value;

	private Integer label4Flg;

	private String label4Name;

	private String label4Value;

	private Integer label5Flg;

	private String label5Name;

	private String label5Value;

	private Integer label6Flg;

	private String label6Name;

	private String label6Value;

	private Integer label7Flg;

	private String label7Name;

	private String label7Value;

	private Integer label8Flg;

	private String label8Name;

	private String label8Value;

	private Integer label9Flg;

	private String label9Name;

	private String label9Value;

	private Integer label10Flg;

	private String label10Name;

	private String label10Value;

}
