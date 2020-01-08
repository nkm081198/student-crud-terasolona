package vn.cwa.application.app.student;

import lombok.Data;

@Data
public class StudentInput {
	private Long id;
	private String name;
	private Integer age;
	private String dateOfBirth;
}
