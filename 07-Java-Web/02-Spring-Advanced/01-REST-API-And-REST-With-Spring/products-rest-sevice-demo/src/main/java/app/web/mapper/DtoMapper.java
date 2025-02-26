package app.web.mapper;

import app.model.Product;
import app.web.dto.ProductResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoMapper {

    public static ProductResponse toProductResponse(Product product) {

        return ProductResponse.builder()
                .name(product.getName())
                .quantity(product.getQuantity())
                .build();
    }
}
