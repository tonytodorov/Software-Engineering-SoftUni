package vehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put("Car", createVehicle(scanner.nextLine().split("\\s+")));
        vehicles.put("Truck", createVehicle(scanner.nextLine().split("\\s+")));
        vehicles.put("Bus", createVehicle(scanner.nextLine().split("\\s+")));


        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Vehicle vehicle = vehicles.get(tokens[1]);
            double param = Double.parseDouble(tokens[2]);

            try {
                switch (tokens[0]) {
                    case "Drive":
                        vehicle.setEmpty(false);
                        vehicle.turnOnOfAc(vehicle.isEmpty());
                        System.out.println(vehicle.drive(param));
                        break;
                    case "Refuel":
                        vehicle.refuel(param);
                        break;
                    case "DriveEmpty":
                        vehicle.setEmpty(true);
                        vehicle.turnOnOfAc(vehicle.isEmpty());
                        System.out.println(vehicle.drive(param));
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] tokens) {
        switch (tokens[0]) {
            case "Car":
                return new Car(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Truck":
                return new Truck(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Bus":
                return new Bus(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            default:
                throw new IllegalArgumentException(String.format("Unknown type of vehicle %s", tokens[0]));
        }
    }
}
