package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.enums.Genre;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class BookServiceImpl implements BookService {

    private final static String BOOKS_PATH = "src/main/resources/files/json/books.json";

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOKS_PATH));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder sb = new StringBuilder();

        BookImportDto[] bookImportDtos = this.gson.fromJson(readBooksFromFile(), BookImportDto[].class);

        for (BookImportDto bookImportDto : bookImportDtos) {
            if (this.bookRepository.findByTitle(bookImportDto.getTitle()).isPresent() ||
                    !this.validationUtil.isValid(bookImportDto)) {
                sb.append("Invalid book").append(System.lineSeparator());
                continue;
            }

            Book book = this.modelMapper.map(bookImportDto, Book.class);
            book.setGenre(Genre.valueOf(bookImportDto.getGenre()));
            this.bookRepository.saveAndFlush(book);

            sb.append(String.format("Successfully imported book %s - %s",
                    book.getAuthor(),
                    book.getTitle()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
