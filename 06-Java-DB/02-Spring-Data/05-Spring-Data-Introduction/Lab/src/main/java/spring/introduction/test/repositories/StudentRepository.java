package spring.introduction.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.introduction.test.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
