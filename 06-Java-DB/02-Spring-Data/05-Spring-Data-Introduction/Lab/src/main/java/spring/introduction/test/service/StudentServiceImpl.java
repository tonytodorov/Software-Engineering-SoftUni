package spring.introduction.test.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import spring.introduction.test.entities.Student;
import spring.introduction.test.repositories.StudentRepository;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void register(Student student) {
        System.out.println("Register the student");
        studentRepository.save(student);
    }

    @Override
    public Student get(int id) {
        Optional<Student> byId = studentRepository.findById(id);

        return byId.orElseThrow(EntityNotFoundException::new);
    }
}
