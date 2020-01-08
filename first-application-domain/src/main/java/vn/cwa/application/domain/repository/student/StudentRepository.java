package vn.cwa.application.domain.repository.student;

import java.util.List;
import java.util.Optional;

import vn.cwa.application.domain.model.Student;

public interface StudentRepository {
	Optional<Student> findById(Long id);
	List<Student> findAll();
	void insert(Student student);
	void update(Student student);
	void deleteById(Long id);
}
