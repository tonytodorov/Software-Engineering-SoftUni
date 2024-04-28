package strategy;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private List<Product> products;

    public Products() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts() {
        products.add(new Product("Milk", 2));
        products.add(new Product("Biscuits", 4));
        products.add(new Product("Meat", 10));
    }

}
