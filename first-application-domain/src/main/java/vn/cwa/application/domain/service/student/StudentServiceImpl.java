package vn.cwa.application.domain.service.student;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.cwa.application.domain.model.Student;
import vn.cwa.application.domain.repository.student.StudentRepository;

@Transactional
@Service
public class StudentServiceImpl implements StudentService{
	
	@Inject
	StudentRepository studentRepository;

	@Override
	public Student findOne(Long id) {
		return studentRepository.findById(id).orElse(new Student());
	}

	@Override
	public Student register(Student student) {
		studentRepository.insert(student);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Long editStudent(Student newStudent) {
		studentRepository.update(newStudent);
		return newStudent.getId();
	}

	@Override
	public Long removeStudent(Long id) {
		studentRepository.deleteById(id);
		return id;
	}

	
	
	
}
