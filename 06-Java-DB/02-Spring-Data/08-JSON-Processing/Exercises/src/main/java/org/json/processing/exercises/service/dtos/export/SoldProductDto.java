package org.json.processing.exercises.service.dtos.export;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class SoldProductDto {

    @Expose
    private int count;

    @Expose
    private Set<ProductInfoDto> products;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<ProductInfoDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductInfoDto> products) {
        this.products = products;
    }
}
