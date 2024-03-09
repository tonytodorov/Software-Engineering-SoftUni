package wild_farm;

import java.text.DecimalFormat;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
        this.livingRegion = livingRegion;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();
    public abstract boolean canEat(Food food);

    public void eat(Food food) {
        if (canEat(food)) {
            this.foodEaten += food.getQuantity();
        } else {
            System.out.println(getClass().getSimpleName() + "s are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName(),
                this.animalName,
                new DecimalFormat("#.##").format(this.animalWeight),
                this.livingRegion,
                this.foodEaten);
    }
}
