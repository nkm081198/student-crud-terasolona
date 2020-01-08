package vn.cwa.application.domain.service.student;

import java.util.List;

import vn.cwa.application.domain.model.Student;

public interface StudentService {
	Student findOne(Long id);
	Student register(Student student);
	List<Student> getAllStudent();
	Long editStudent(Student newStudent);
	Long removeStudent(Long id);
}
