package grocery.cart;

import grocery.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public double totalCost() {
        double totalCost = 0;

        for (Product product : products) {
            double price = product.getPrice();
            double quantity = product.getQuantity();
            totalCost += price * quantity;
        }

        return totalCost;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String item) {
        products.removeIf(product -> product.getClass().getSimpleName().equals(item));
    }

}
