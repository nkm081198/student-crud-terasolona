package vn.cwa.application.app.converter;

import java.text.SimpleDateFormat;

import vn.cwa.application.app.student.StudentInput;
import vn.cwa.application.domain.model.Student;

public class StudentConvertter {
	public static StudentInput convertToInPut(Student student) {
		StudentInput studentInput = new StudentInput();
		studentInput.setId(student.getId());
		studentInput.setName(student.getName());
		studentInput.setAge(student.getAge());
		try {
			studentInput.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").format(student.getDateOfBirth()));
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return studentInput;
	}
}
