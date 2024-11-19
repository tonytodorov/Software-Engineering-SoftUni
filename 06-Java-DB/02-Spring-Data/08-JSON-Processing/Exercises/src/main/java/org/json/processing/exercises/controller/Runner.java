package org.json.processing.exercises.controller;

import org.json.processing.exercises.service.CategoryService;
import org.json.processing.exercises.service.ProductService;
import org.json.processing.exercises.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public Runner(CategoryService categoryService, UserService userService, ProductService productService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!this.categoryService.isImported()) {
            this.categoryService.seedCategories();
        }

        if (!this.userService.isImported()) {
            this.userService.seedUsers();
        }

        if (!this.productService.isImported()) {
            this.productService.seedProducts();
        }

//        this.productService.exportProductsInRange();
//        this.userService.successfullySoldProducts();
//        this.categoryService.exportCategories();
        this.userService.usersAndProducts();
    }
}
