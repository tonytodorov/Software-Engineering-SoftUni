package grocery.products;

public abstract class Product {

    private double price;
    private double quantity;

    protected Product(double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }
}
