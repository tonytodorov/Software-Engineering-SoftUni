package wild_farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(command)) {
            Animal animal = createAnimal(command);
            Food food = createFood(scanner.nextLine());

            animal.makeSound();
            animal.eat(food);

            animals.add(animal);

            command = scanner.nextLine();
        }

        animals.forEach(System.out::println);
    }

    private static Food createFood(String line) {
        String[] token = line.split("\\s+");

        String foodType = token[0];
        Integer quantity = Integer.parseInt(token[1]);

        return "Meat".equals(foodType) ? new Meat(quantity) : new Vegetable(quantity);
    }

    private static Animal createAnimal(String command) {
        String[] token = command.split("\\s+");

        String type = token[0];
        String name = token[1];
        Double weight = Double.valueOf(token[2]);
        String livingRegion = token[3];

        Animal animal;

        if ("Cat".equals(type)) {
            animal = new Cat(name, type, weight, livingRegion, token[4]);
        } else if ("Tiger".equals(type)) {
            animal = new Tiger(name, type, weight, livingRegion);
        } else if ("Mouse".equals(type)) {
            animal = new Mouse(name, type, weight, livingRegion);
        } else {
            animal = new Zebra(name, type, weight, livingRegion);
        }

        return animal;
    }
}
