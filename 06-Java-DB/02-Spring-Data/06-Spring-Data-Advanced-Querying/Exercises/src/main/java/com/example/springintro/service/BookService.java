package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.Query;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findTitlesByAgeRestriction(String ageRestriction);

    List<String> findGoldenBookTitles();

    List<String> findBooksByPrice(BigDecimal lowerBound, BigDecimal upperBound);

    List<String> findNotReleasedBooks(LocalDate localDate);

    List<String> findBooksReleasedBeforeDate(LocalDate localDate);

    List<String> findBooksByContainingGivenString(String str);

    List<String> findBookTitleSearch(String str);

    int countBooks(int length);

    BookInfo findBookInfo(String title);

    long updateBookCopiesAfterDate(String parsedDate, int count);

    int deleteWithCountLessThan(int minCount);
}
