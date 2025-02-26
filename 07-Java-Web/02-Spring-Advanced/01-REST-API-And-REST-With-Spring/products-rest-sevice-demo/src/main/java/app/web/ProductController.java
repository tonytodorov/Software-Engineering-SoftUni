package app.web;

import app.model.Product;
import app.service.ProductService;
import app.web.dto.NewProductRequest;
import app.web.dto.ProductResponse;
import app.web.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static app.utils.Paths.API_V1_BASE_PATH;

@RestController
@RequestMapping(API_V1_BASE_PATH + "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {

        List<ProductResponse> productResponses = productService.getAllProducts()
                .stream()
                .map(DtoMapper::toProductResponse)
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productResponses);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createNewProduct(@RequestBody NewProductRequest newProductRequest) {

        Product product = productService.createNewProduct(newProductRequest);

        ProductResponse productResponse = DtoMapper.toProductResponse(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Application-name", "SpringBootProject")
                .body(productResponse);
    }
}
