package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.CustomRepository;
import com.example.advquerying.repositories.IngredientsRepository;
import com.example.advquerying.repositories.LabelRepository;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final IngredientsRepository ingredientsRepository;
    private final LabelRepository labelRepository;
    private final CustomRepository customRepository;

    @Autowired
    public Runner(ShampooRepository shampooRepository, IngredientsRepository ingredientsRepository, LabelRepository labelRepository, CustomRepository customRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.labelRepository = labelRepository;
        this.customRepository = customRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        _01_SelectShampoosBySize();
//        _02_SelectShampooBySizeOrLabel();
//        _03_SelectShampoosByPrice();
//        _04_SelectIngredientsByName();
//        _05_SelectIngredientsByNames();
//        _06_CountShampoosByPrice();
//        _07_SelectShampoosByIngredients();
//        _08_SelectShampoosByIngredientsCount();
//        _09_DeleteIngredientsByName();
//        _10_UpdateIngredientsByPrice();
//        _11_UpdateIngredientsByNames();

        // Custom repository
//        Shampoo firstShampoo = customRepository.getFirstShampoo();
//        System.out.println(firstShampoo.getBrand());
    }

    private void _11_UpdateIngredientsByNames() {
        ingredientsRepository.updateIngredientsPricesForNames(List.of("Lavender"));
    }

    private void _10_UpdateIngredientsByPrice() {
        ingredientsRepository.updateIngredientsPriceBy10Percent();
    }
    private void _09_DeleteIngredientsByName() {
        ingredientsRepository.deleteByName("Lavender");
    }

    private void _08_SelectShampoosByIngredientsCount() {
        List<Shampoo> byIngredientsCountLessThan = shampooRepository
                .findByIngredientsCountLessThan(2);
        byIngredientsCountLessThan.forEach(s -> System.out.println(s.getBrand()));

    }

    private void _07_SelectShampoosByIngredients() {
        // With built-in method
        List<Shampoo> byIngredientsNameIn = shampooRepository
                .findByIngredientsNameIn(List.of("Berry", "Mineral-Collagen"));

        byIngredientsNameIn.forEach(s -> System.out.println(s.getBrand()));

        // With @Query annotation
        List<Shampoo> byIngredientsNameInQuery = shampooRepository
                .findByIngredientsNameInQuery(List.of("Berry", "Mineral-Collagen"));

        byIngredientsNameInQuery.forEach(s -> System.out.println(s.getBrand()));
    }

    private void _06_CountShampoosByPrice() {
        List<Shampoo> shampoos = shampooRepository
                .findShampoosByPriceIsLessThan(BigDecimal.valueOf(8.50));

        System.out.println(shampoos.size());
    }

    private void _05_SelectIngredientsByNames() {
        List<Ingredient> allByNameIn = ingredientsRepository
                .findAllByNameInOrderByPrice(List.of("Lavender", "Herbs", "Apple"));

        allByNameIn.forEach(i -> System.out.println(i.getName()));
    }

    private void _04_SelectIngredientsByName() {
        List<Ingredient> byNameStartingWith = ingredientsRepository
                .findByNameStartingWith("M");

        byNameStartingWith.forEach(i -> System.out.println(i.getName()));
    }

    private void _03_SelectShampoosByPrice() {
        List<Shampoo> byPriceGreaterThanOrderByPriceDesc = shampooRepository
                .findByPriceGreaterThanOrderByPriceDesc(BigDecimal.valueOf(5));

        byPriceGreaterThanOrderByPriceDesc.forEach(s ->
                System.out.printf("%s %s %slv.%n", s.getBrand(), s.getSize(), s.getPrice()));
    }

    private void _02_SelectShampooBySizeOrLabel() {

        // With Long field
        List<Shampoo> findBySizeOrLabelIdOrderByPrice = shampooRepository
                .findBySizeOrLabelIdOrderByPrice(Size.MEDIUM, 10L);

        findBySizeOrLabelIdOrderByPrice.forEach(s ->
                System.out.printf("%s %s %slv.%n", s.getBrand(), s.getSize(), s.getPrice()));

        // With Label field
        Label labelById = labelRepository.findLabelById(10L);

        List<Shampoo> bySizeOrLabelOrderByPrice = shampooRepository
                .findBySizeOrLabelOrderByPrice(Size.MEDIUM, labelById);

        bySizeOrLabelOrderByPrice.forEach(s ->
                System.out.printf("%s %s %slv.%n", s.getBrand(), s.getSize(), s.getPrice()));
    }

    private void _01_SelectShampoosBySize() {
        List<Shampoo> bySizeOrderById = shampooRepository
                .findBySizeOrderById(Size.MEDIUM);
        
        bySizeOrderById.forEach(s -> 
                System.out.printf("%s %s %slv.%n", s.getBrand(), s.getSize(), s.getPrice()));
    }
}
