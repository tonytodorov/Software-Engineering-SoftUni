package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");

        vehicles.put("Car", new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2])));
        vehicles.put("Truck", new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2])));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String operation = tokens[0];
            String type = tokens[1];
            double argument = Double.parseDouble(tokens[2]);

            if (operation.equals("Drive")) {
                vehicles.get(type).drive(argument);
            } else if (operation.equals("Refuel")) {
                vehicles.get(type).refuel(argument);
            }
        }

        vehicles.values().forEach(System.out::println);
    }
}
