package solid.products;

public class Chocolate extends Product {

    private static final double CHOCOLATE_CALORIES_PER_100_GRAMS = 575.0;

    public Chocolate(double quantity) {
        super(quantity);
    }

    @Override
    public double calculateCalories() {
        return (CHOCOLATE_CALORIES_PER_100_GRAMS / 100) * super.getQuantity();
    }
}
