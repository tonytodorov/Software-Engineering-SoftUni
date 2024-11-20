package org.json.processing.exercises.service;

import java.io.IOException;

public interface UserService {

    void seedUsers() throws IOException;

    boolean isImported();

    void successfullySoldProducts() throws IOException;

    void usersAndProducts() throws IOException;
}
