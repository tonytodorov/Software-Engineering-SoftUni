package org.json.processing.exercises.service.impls;

import com.google.gson.Gson;
import jakarta.validation.ConstraintViolation;
import org.json.processing.exercises.data.entities.Category;
import org.json.processing.exercises.data.entities.Product;
import org.json.processing.exercises.data.repository.CategoryRepository;
import org.json.processing.exercises.service.CategoryService;
import org.json.processing.exercises.service.dtos.export.CategoryExportJsonDto;
import org.json.processing.exercises.service.dtos.imports.CategorySeedJsonDto;
import org.json.processing.exercises.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String JSON_PATH = "src/main/resources/json/categories.json";

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public void seedCategories() throws IOException {
        String jsonString = String.join("", Files.readAllLines(Path.of(JSON_PATH)));
        CategorySeedJsonDto[] categorySeedJsonDTO = this.gson
                .fromJson(jsonString, CategorySeedJsonDto[].class);

        for (CategorySeedJsonDto seedJsonDTO : categorySeedJsonDTO) {
            if (!this.validatorUtil.isValid(seedJsonDTO)) {
                System.out.println(this.validatorUtil.validate(seedJsonDTO)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.joining()));
                continue;
            }

            this.categoryRepository.saveAndFlush(this.modelMapper.map(seedJsonDTO, Category.class));
        }
    }

    @Override
    public boolean isImported() {
        return this.categoryRepository.count() > 0;
    }

    @Override
    public void exportCategories() throws IOException {
        Set<CategoryExportJsonDto> categoryExportJsonDtos = this.categoryRepository.findAll()
                .stream()
                .map(c -> {
                    double sum = c.getProducts()
                            .stream()
                            .mapToDouble(p -> p.getPrice().doubleValue()).sum();

                    return new CategoryExportJsonDto(
                            c.getName(),
                            c.getProducts().size(),
                            BigDecimal.valueOf(sum / c.getProducts().size()),
                            BigDecimal.valueOf(sum));
                })
                .sorted((a, b) -> Integer.compare(b.getProductsCount(), a.getProductsCount()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

       ;

        String json = this.gson.toJson(categoryExportJsonDtos);
        FileWriter fileWriter = new FileWriter("src/main/resources/json/export/categories-by-products.json");

        fileWriter.write(json);
        fileWriter.close();

    }
}
