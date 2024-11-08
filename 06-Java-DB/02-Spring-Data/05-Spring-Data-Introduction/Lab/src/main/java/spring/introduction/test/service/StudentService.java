package spring.introduction.test.service;

import spring.introduction.test.entities.Student;

public interface StudentService {

    void register(Student student);

    Student get(int id);
}
