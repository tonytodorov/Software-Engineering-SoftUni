package pizza_calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        if (!this.toppings.contains(topping)) {
            toppings.add(topping);
        }
    }

    public double getOverallCalories() {
        return this.toppings.stream()
                .mapToDouble(Topping::calculateCalories)
                .sum() +
                this.dough.calculateCalories();
    }
}
