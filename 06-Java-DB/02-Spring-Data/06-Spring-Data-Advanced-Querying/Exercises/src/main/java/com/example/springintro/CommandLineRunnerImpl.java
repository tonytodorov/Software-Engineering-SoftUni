package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        seedData();

//        _01_BooksTitlesByAgeRestriction();
//        _02_GoldenBooks();
//        _03_BooksByPrice();
//        _04_NotReleasedBooks();
//        _05_BooksReleasedBeforeDate();
//        _06_AuthorsSearch();
//        _07_BookSearch();
//        _08_BooksTitlesSearch();
//        _09_CountBooks();
//        _10_TotalBookCopies();
//        _11_ReducedBook();

//        _12_IncreaseBookCopies(scanner);
//        _13_RemoveBooks(scanner);
        _14_StoredProcedure();
    }

    private void _14_StoredProcedure() {
        int bookCountForAuthor = authorService.findBookCountForAuthor("Roger", "Porter");

        System.out.println(bookCountForAuthor);
    }

    private void _13_RemoveBooks(Scanner scanner) {
        int minCount = Integer.parseInt(scanner.nextLine());
        int deletedBooksCount = bookService.deleteWithCountLessThan(minCount);

        System.out.println(deletedBooksCount);
    }

    private void _12_IncreaseBookCopies(Scanner scanner) {
        String date = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        long total = bookService.updateBookCopiesAfterDate(date, count);
        System.out.println(total);
    }

    private void _11_ReducedBook() {
        BookInfo bookInfo = bookService.findBookInfo("Things Fall Apart");

        System.out.printf("%s %s %s %.2f%n", bookInfo.getTitle(),
                bookInfo.getEditionType(),
                bookInfo.getAgeRestriction(),
                bookInfo.getPrice());
    }

    private void _10_TotalBookCopies() {
         authorService.getAllByBookCopiesCount()
                 .forEach(System.out::println);
    }

    private void _09_CountBooks() {
        System.out.println(bookService.countBooks(12));
    }

    private void _08_BooksTitlesSearch() {
        bookService.findBookTitleSearch("Ric")
                .forEach(System.out::println);
    }

    private void _07_BookSearch() {
        bookService.findBooksByContainingGivenString("sK")
                .forEach(System.out::println);
    }

    private void _06_AuthorsSearch() {
        authorService.authorsSearch("e")
                .forEach(System.out::println);
    }

    private void _05_BooksReleasedBeforeDate() {
        bookService.findBooksReleasedBeforeDate(LocalDate.of(1992, 4, 12))
                .forEach(System.out::println);
    }

    private void _04_NotReleasedBooks() {
        bookService.findNotReleasedBooks(LocalDate.of(2000, 1, 1))
                .forEach(System.out::println);
    }

    private void _03_BooksByPrice() {
        bookService.findBooksByPrice(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(System.out::println);
    }

    private void _02_GoldenBooks() {
        bookService.findGoldenBookTitles()
                .forEach(System.out::println);
    }

    private void _01_BooksTitlesByAgeRestriction() {
        bookService.findTitlesByAgeRestriction("miNOR")
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
