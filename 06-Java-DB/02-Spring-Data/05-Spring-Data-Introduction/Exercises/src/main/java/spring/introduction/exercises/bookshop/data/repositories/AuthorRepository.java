package spring.introduction.exercises.bookshop.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.introduction.exercises.bookshop.data.entities.Author;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Set<Author> findAllByBooksReleaseDateBefore(LocalDate date);

    Set<Author> findAllByOrderByBooksDesc();
}
