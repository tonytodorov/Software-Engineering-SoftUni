import java.util.*;

public class _03_NeedForSpeed3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");

            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);

            if (!cars.containsKey(car)) {
                cars.put(car, new ArrayList<>());
            }

            cars.get(car).add(mileage);
            cars.get(car).add(fuel);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] tokens = command.split("\\s+:\\s+");
            String operation = tokens[0];

            if (operation.equals("Drive")) {
                drive(cars, tokens);
            } else if (operation.equals("Refuel")) {
                refuel(cars, tokens);
            } else if (operation.equals("Revert")) {
                revert(cars, tokens);
            }

            command = scanner.nextLine();
        }

        print(cars);
    }

    public static void drive(Map<String, List<Integer>> cars, String[] tokens) {

        String car = tokens[1];
        int distance = Integer.parseInt(tokens[2]);
        int fuel = Integer.parseInt(tokens[3]);

        int availableFuel = cars.get(car).get(1);

        if (availableFuel > fuel) {
            cars.get(car).set(0, cars.get(car).get(0) + distance);
            cars.get(car).set(1, cars.get(car).get(1) - fuel);

            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                    car, distance, fuel);
        } else {
            System.out.println("Not enough fuel to make that ride");
        }

        if (cars.get(car).get(0) > 100_000) {
            cars.remove(car);
            System.out.printf("Time to sell the %s!%n", car);
        }
    }

    public static void refuel(Map<String, List<Integer>> cars, String[] tokens) {

        String car = tokens[1];
        int fuel = Integer.parseInt(tokens[2]);

        if (cars.get(car).get(1) + fuel <= 75) {
            cars.get(car).set(1, cars.get(car).get(1) + fuel);
            System.out.printf("%s refueled with %d liters%n", car, fuel);
        } else {
            int difference = 75 - cars.get(car).get(1);
            cars.get(car).set(1, 75);
            System.out.printf("%s refueled with %d liters%n", car, difference);
        }
    }

    public static void revert(Map<String, List<Integer>> cars, String[] tokens) {

        String car = tokens[1];
        int kilometers = Integer.parseInt(tokens[2]);

        cars.get(car).set(0, cars.get(car).get(0) - kilometers);

        if (cars.get(car).get(0) < 10_000) {
            cars.get(car).set(0, 10_000);
        } else {
            System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
        }
    }

    public static void print(Map<String, List<Integer>> cars) {

        for (Map.Entry<String, List<Integer>> entry: cars.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    entry.getKey(),
                    entry.getValue().get(0),
                    entry.getValue().get(1));
        }
    }
}
