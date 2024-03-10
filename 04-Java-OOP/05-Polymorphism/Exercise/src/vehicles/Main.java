package vehicles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            String operation = token[0];
            String vehicleType = token[1];

            drive(car, truck, token, operation, vehicleType);
            refuel(car, truck, token, operation, vehicleType);
        }

        System.out.println(car);
        System.out.println(truck);
    }

    private static void refuel(Car car, Truck truck, String[] token, String operation, String vehicleType) {
        if ("Refuel".equals(operation)) {
            double liters = Double.parseDouble(token[2]);

            if ("vehicles_extension.Car".equals(vehicleType)) {
                car.refueling(liters);
            } else {
                truck.refueling(liters);
            }
        }
    }

    private static void drive(Car car, Truck truck, String[] token, String operation, String vehicleType) {
        if ("Drive".equals(operation)) {
            double distance = Double.parseDouble(token[2]);

            if ("vehicles_extension.Car".equals(vehicleType)) {
                car.driving(distance);
            } else {
                truck.driving(distance);
            }
        }
    }
}
