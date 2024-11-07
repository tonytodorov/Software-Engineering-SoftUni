package spring.introduction.exercises.bookshop.service;

import java.io.IOException;

public interface CategoryService {

    void seedCategories() throws IOException;

    boolean isImported();
}
