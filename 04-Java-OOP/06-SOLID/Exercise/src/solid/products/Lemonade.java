package solid.products;

public class Lemonade extends Product {

    public static final double LEMONADE_CALORIES_PER_100_GRAMS = 53.0;
    public static final double LEMONADE_DENSITY = 0.7;


    public Lemonade(double quantity) {
        super(quantity);
    }

    @Override
    public double calculateCalories() {
        return (LEMONADE_CALORIES_PER_100_GRAMS / 100) * (super.getQuantity() * LEMONADE_DENSITY);
    }
}
