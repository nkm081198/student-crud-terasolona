package vn.cwa.application.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Integer age;
	private Date dateOfBirth;

}
