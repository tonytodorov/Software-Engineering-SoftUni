package spring.introduction.exercises.bookshop.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.introduction.exercises.bookshop.data.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
