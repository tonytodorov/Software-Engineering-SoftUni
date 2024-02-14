package vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int capacity) {
        this.buttonCapacity = capacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < this.buttonCapacity) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        return this.drinks.removeIf(drink -> drink.getName().equals(name));
    }

    public Drink getLongest() {
       return this.drinks.stream().
               max(Comparator.comparingInt(Drink::getVolume))
               .orElse(null);
    }

    public Drink getCheapest() {
        return this.drinks.stream().
                min(Comparator.comparing(Drink::getPrice))
                .orElse(null);
    }

    public String buyDrink(String name) {
        Drink currDrink = this.drinks.stream()
                .filter(drink -> drink.getName().equals(name))
                .findFirst().orElse(null);

        return currDrink.toString();
    }

    public String report() {
         return String.format("Drinks available: %n%s", drinks.stream()
                 .map(String::valueOf)
                 .collect(Collectors.joining(System.lineSeparator())));
    }
}
