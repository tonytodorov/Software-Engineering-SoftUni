package org.json.processing.exercises.service.impls;

import com.google.gson.Gson;
import org.json.processing.exercises.data.entities.Category;
import org.json.processing.exercises.data.entities.Product;
import org.json.processing.exercises.data.entities.User;
import org.json.processing.exercises.data.repository.CategoryRepository;
import org.json.processing.exercises.data.repository.ProductRepository;
import org.json.processing.exercises.data.repository.UserRepository;
import org.json.processing.exercises.service.ProductService;
import org.json.processing.exercises.service.dtos.export.ProductExportJsonDto;
import org.json.processing.exercises.service.dtos.imports.ProductSeedJsonDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String JSON_PATH = "src/main/resources/json/products.json";

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedProducts() throws IOException {
        ProductSeedJsonDto[] productSeedJsonDtos = this.gson.fromJson(
                String.join("", Files.readAllLines(Path.of(JSON_PATH))), ProductSeedJsonDto[].class);

        for (ProductSeedJsonDto productSeedJsonDto : productSeedJsonDtos) {
            Product product = this.modelMapper.map(productSeedJsonDto, Product.class);
            product.setSeller(getRandomUser(true));
            product.setBuyer(getRandomUser(false));
            product.setCategories(getRandomCategories());

            this.productRepository.saveAndFlush(product);
        }
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();

        int count = ThreadLocalRandom.current().nextInt(1,4);

        for (int i = 0; i < count; i++) {
            categories.add(this.categoryRepository.findById(ThreadLocalRandom
                    .current()
                    .nextInt(1, (int) (this.categoryRepository.count() + 1))).get());
        }

        return categories;
    }

    private User getRandomUser(boolean flag) {
        int randomId;

        if (flag) {
            randomId = ThreadLocalRandom.current()
                    .nextInt(1, (int) (this.userRepository.count() + 1));
        } else {
            randomId = ThreadLocalRandom.current().nextInt(1, (int) (this.userRepository.count()));
        }

        return this.userRepository.findById(randomId).get();
    }

    @Override
    public boolean isImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public void exportProductsInRange() throws IOException {
        Set<Product> allByPriceBetweenAndBuyerIsNull = this.productRepository
                .findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        Set<ProductExportJsonDto> dtos = allByPriceBetweenAndBuyerIsNull
                .stream()
                .map(p -> {
                    ProductExportJsonDto product = this.modelMapper.map(p, ProductExportJsonDto.class);
                    product.setName(p.getSeller().getFirstName() + " " + p.getSeller().getLastName());
                    return product;
                })
                .collect(Collectors.toSet());

        String json = this.gson.toJson(dtos);
        FileWriter fileWriter = new FileWriter("src/main/resources/json/export/products-in-range.json");

        fileWriter.write(json);
        fileWriter.close();
    }
}
