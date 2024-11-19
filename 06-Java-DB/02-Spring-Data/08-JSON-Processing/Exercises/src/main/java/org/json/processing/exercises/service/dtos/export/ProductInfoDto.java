package org.json.processing.exercises.service.dtos.export;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductInfoDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
