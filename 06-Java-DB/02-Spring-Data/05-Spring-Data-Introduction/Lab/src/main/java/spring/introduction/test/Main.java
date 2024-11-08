package spring.introduction.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.introduction.test.entities.Student;
import spring.introduction.test.service.StudentService;

@Component
public class Main implements CommandLineRunner {

    private StudentService studentService;

    public Main(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Working in Spring");
//        studentService.register(new Student("Dimitar"));
        Student fromDb = studentService.get(1);
        studentService.get(5);
    }
}
