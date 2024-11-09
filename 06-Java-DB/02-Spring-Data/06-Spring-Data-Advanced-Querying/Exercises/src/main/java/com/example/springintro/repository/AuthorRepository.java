package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.AuthorCopies;
import com.example.springintro.model.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY SIZE(a.books) DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> getAuthorsByFirstNameEndingWith(String str);

    @Query("""
        SELECT a.firstName AS firstName, a.lastName AS lastName, SUM(b.copies) AS copyCount
        FROM Book AS b
        JOIN b.author AS a
        GROUP BY b.author
        ORDER BY copyCount DESC
""")
    List<AuthorCopies> findAuthorsByBookCopiesCount();


//    @Query("""
//        SELECT new com.example.springintro.model.entity.Example(a.firstName, a.lastName, SUM(b.copies))
//        FROM Book AS b
//        JOIN b.author AS a
//        GROUP BY b.author
//        ORDER BY copyCount DESC
//""")
//    List<Example> findAuthorsByBookCopiesCountClassBased();

    @Procedure(procedureName = "usp_author_written_books", outputParameterName = "result")
    int findBookCount(String firstName, String lastName);
}
