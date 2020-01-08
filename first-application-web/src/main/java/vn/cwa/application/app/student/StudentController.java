package vn.cwa.application.app.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.cwa.application.app.converter.StudentConvertter;
import vn.cwa.application.domain.model.Student;
import vn.cwa.application.domain.service.student.StudentService;

@Controller
@RequestMapping(value = "student")
public class StudentController {
	
	@Inject
	StudentService studentService;
	
	@RequestMapping(value = "insert", params = "form", method = RequestMethod.GET)
	public String createForm() {
		return "student/insert";
	}
	
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable("id") Long id, Model model) {
		StudentInput studentInput = StudentConvertter.convertToInPut(studentService.findOne(id));
		model.addAttribute("model", studentInput);
		return "student/edit";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(StudentInput studentIP) {
		Student student = new Student();
		student.setName(studentIP.getName());
		student.setAge(studentIP.getAge());
		try {
			student.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(studentIP.getDateOfBirth()));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		studentService.register(student);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(StudentInput studentIP) {
		Student student = new Student();
		student.setId(studentIP.getId());
		student.setName(studentIP.getName());
		student.setAge(studentIP.getAge());
		try {
			student.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(studentIP.getDateOfBirth()));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		studentService.editStudent(student);
		return "redirect:/";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id) {
		studentService.removeStudent(id);
		return "redirect:/";
	}
	
	
}
