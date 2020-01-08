package vn.cwa.application.app.welcome;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.cwa.application.app.student.StudentInput;
import vn.cwa.application.domain.model.Student;
import vn.cwa.application.domain.service.student.StudentService;


@Controller
@RequestMapping("/")
public class HelloController {
	
	@Inject
	StudentService studentService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model) {
		List<StudentInput> lst = studentService.getAllStudent().stream().map(item -> convertToInPut(item)).collect(Collectors.toList());
		model.addAttribute("listStudent", lst);
		return "welcome/home";
	}
	
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
