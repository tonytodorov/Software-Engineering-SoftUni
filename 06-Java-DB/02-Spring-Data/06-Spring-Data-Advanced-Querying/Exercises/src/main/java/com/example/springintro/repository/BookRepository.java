package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;
import com.example.springintro.model.entity.EditionType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findBooksByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findBooksByPriceLessThanAndPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> findBooksByReleaseDateNot(LocalDate localDate);

    List<Book> findBooksByReleaseDateBefore(LocalDate localDate);

    List<Book> findBooksByTitleContainingIgnoreCase(String title);

    List<Book> findBooksByAuthorLastNameStartingWith(String str);

    @Query("""
        SELECT b
        FROM Book AS b
        WHERE LENGTH(b.title) > :length
    """)
    List<Book> findBooksByCount(int length);

    BookInfo findByTitle(String title);

    @Query("""
        UPDATE Book b
        SET b.copies = b.copies + :count
        WHERE b.releaseDate > :parsedDate
    """)
    @Modifying
    @Transactional
    int updateBookCopiesReleasedAfter(LocalDate parsedDate, int count);

    @Transactional
    int deleteByCopiesLessThan(int count);
}
