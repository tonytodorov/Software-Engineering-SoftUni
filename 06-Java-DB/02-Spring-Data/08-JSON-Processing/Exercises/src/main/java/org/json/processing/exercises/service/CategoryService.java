package org.json.processing.exercises.service;


import java.io.FileNotFoundException;
import java.io.IOException;

public interface CategoryService {

    void seedCategories() throws IOException;

    boolean isImported();

    void exportCategories() throws IOException;
}
