package shopping_spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money >= product.getCost()) {
            money -= product.getCost();
            products.add(product);
            System.out.printf("%s bought %s%n", this.name, product.getName());
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s%n", this.name, product.getName()));
        }
    }

    @Override
    public String toString() {
        return cart();
    }


    private String cart() {
        if (products.isEmpty()) {
            return String.format("%s - Nothing bought", getName());
        }

        return String.format("%s - %s", getName(),
                products.stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", ")));
    }
}
