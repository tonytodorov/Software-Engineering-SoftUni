package speed.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            int fuelAmount = Integer.parseInt(input[1]);
            double fuelCost = Double.parseDouble(input[2]);

            Car car = new Car(model, fuelAmount, fuelCost, 0);

            cars.add(car);
        }

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");

            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            for (Car car : cars) {
                car.calculateDistance(model, distance);
            }
            command = scanner.nextLine();
        }

        cars.forEach(System.out::println);
    }
}
