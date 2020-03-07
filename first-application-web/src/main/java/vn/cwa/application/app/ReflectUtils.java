package vn.cwa.application.app;

import java.io.Serializable;
import java.lang.reflect.Field;

import lombok.Data;
import vn.cwa.application.domain.model.Student;

public class ReflectUtils {

	private ReflectUtils() {
	}

	@SuppressWarnings("rawtypes")
	public static Object getValueOf(Object clazz, String lookingForValue) throws Exception {
		Field field = clazz.getClass().getField(lookingForValue);
		field.setAccessible(true);
		Class clazzType = field.getType();
		if (clazzType.toString().equals("double"))
			return field.getDouble(clazz);
		else if (clazzType.toString().equals("int"))
			return field.getInt(clazz);
		// else other type ...
		// and finally
		return field.get(clazz);
	}

	public static void main(String[] args) throws Exception {
		TestClass test = new TestClass();
		test.setFirstValue("mot");
		test.setSecondValue("hai");
		test.setThirdValue("ba");
		
		Student student = new Student();
	    student.setId(1L);
	    student.setName("manhnk");
	    System.out.println(ReflectUtils.getValueOf(student, "name"));

//		System.out.println(ReflectUtils.getValueOf(test, "firstValue"));
//		System.out.println(ReflectUtils.getValueOf(test, "secondValue"));
//		System.out.println(ReflectUtils.getValueOf(test, "thirdValue"));
	}

}

@Data
class TestClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	public String firstValue = "mot";
//	public String secondValue = "hai";
//	public String thirdValue = "ba";
	
	public String firstValue;
	public String secondValue;
	public String thirdValue;
}
