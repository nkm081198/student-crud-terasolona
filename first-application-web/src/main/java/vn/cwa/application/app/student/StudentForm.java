package vn.cwa.application.app.student;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class StudentForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 20)
	private String name;

	@NotNull
	@Min(0) 
	@Max(110)
	private Integer age;
	
	@NotNull
	private String dateOfBirth;
	
//	@NotNull
//    private Integer yearOfBirth;
//
//    @NotNull
//    @Min(1)
//    @Max(12)
//    private Integer monthOfBirth;
//
//    @NotNull
//    @Min(1)
//    @Max(31)
//    private Integer dayOfBirth;

}
