package car.salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine;

            if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (tokens.length == 3) {
                String field = tokens[2];

                if (field.matches("\\d+")) {
                    engine = new Engine(model, power, Integer.parseInt(field));
                } else {
                    engine = new Engine(model, power, field);
                }
            } else {
                engine = new Engine(model, power);
            }

            engineList.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            String engine = tokens[1];

            Car car;

            if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            } else if (tokens.length == 3) {
                String field = tokens[2];

                if (field.matches("\\d+")) {
                    car = new Car(model, engine, Integer.parseInt(field));
                } else {
                    car = new Car(model, engine, field);
                }
            } else {
                car = new Car(model, engine);
            }

            carList.add(car);
        }


        for (Car car: carList) {
            for (Engine engine: engineList) {
                if (car.getEngine().equals(engine.getModel())) {

                }
            }
        }
    }
}
