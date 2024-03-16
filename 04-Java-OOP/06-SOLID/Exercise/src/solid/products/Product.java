package solid.products;

public abstract class Product {

    private double quantity;

    protected Product(double quantity) {
        this.quantity = quantity;
    }

    protected double getQuantity() {
        return quantity;
    }

    public abstract double calculateCalories();
}
