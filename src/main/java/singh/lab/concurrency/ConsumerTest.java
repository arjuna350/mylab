package singh.lab.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import singh.lab.model.Student;

public class ConsumerTest {

	public static void main(String[] args) {
		
		Consumer<Student> style = (Student s) -> System.out.println("Name:"+s.name +" and Age:"+s.age);

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Shailesh",31));
		studentList.add(new Student("Nilesh",29));
		studentList.add(new Student("Vinay",34));
		
		
		studentList.forEach(style);
	}

}
