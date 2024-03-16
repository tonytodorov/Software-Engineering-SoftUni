package solid.products;

public class Coke extends Product {

    private static final double COKE_CALORIES_PER_100_GRAMS = 44.0;
    private static final double COKE_DENSITY = 0.6;

    public Coke(double quantity) {
        super(quantity);
    }

    @Override
    public double calculateCalories() {
        return (COKE_CALORIES_PER_100_GRAMS / 100) * (super.getQuantity() * COKE_DENSITY);
    }


}
