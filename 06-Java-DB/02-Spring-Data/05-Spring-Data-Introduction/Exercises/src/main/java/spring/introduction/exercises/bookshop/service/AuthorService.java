package spring.introduction.exercises.bookshop.service;

import java.io.IOException;

public interface AuthorService {

    void seedAuthors() throws IOException;

    boolean areAuthorsImported();

    void printAllAuthorsWithOneBookBefore1990();

    void printAllAuthorsWithDescCount();
}
