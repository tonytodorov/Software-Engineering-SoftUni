package org.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.jpa.entities.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-unit");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Student insert = new Student("Nikolay");
        entityManager.persist(insert);

        Student found = entityManager.find(Student.class, 1L);

        System.out.println(found);

        List<Student> fromStudent = entityManager
                .createQuery("FROM Student", Student.class).getResultList();

        for (Student student : fromStudent) {
            System.out.println(student);
        }

        Student lastStudent = fromStudent.get(fromStudent.size() - 1);
        entityManager.remove(lastStudent);

        entityManager.getTransaction().commit();
    }
}
