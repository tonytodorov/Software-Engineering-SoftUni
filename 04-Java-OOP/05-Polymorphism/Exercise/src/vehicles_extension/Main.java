package vehicles_extension;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]),
                Double.parseDouble(carInfo[3]));

        Truck truck = new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(truckInfo[2]),
                Double.parseDouble(carInfo[3]));

        Bus bus = new Bus(Double.parseDouble(busInfo[1]),
                Double.parseDouble(busInfo[2]),
                Double.parseDouble(busInfo[3]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            String operation = token[0];
            String vehicleType = token[1];

            drive(car, truck, bus, token, operation, vehicleType);
            refuel(car, truck, bus, token, operation, vehicleType);
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void refuel(Car car, Truck truck, Bus bus, String[] token, String operation, String vehicleType) {
        if ("Refuel".equals(operation)) {
            double liters = Double.parseDouble(token[2]);

            if ("vehicles_extension.Car".equals(vehicleType)) {
                car.refueling(liters);
            } else if ("vehicles_extension.Bus".equals(vehicleType)) {
                bus.refueling(liters);
            } else {
                truck.refueling(liters);
            }
        }
    }

    private static void drive(Car car, Truck truck, Bus bus, String[] token, String operation, String vehicleType) {
        double distance = Double.parseDouble(token[2]);

        if ("DriveEmpty".equals(operation)) {
            bus.driving(distance);
        }

        if ("Drive".equals(operation)) {
            if ("vehicles_extension.Car".equals(vehicleType)) {
                car.driving(distance);
            } else if ("vehicles_extension.Bus".equals(vehicleType)) {
                bus.driving(distance);
            } else if ("vehicles_extension.Truck".equals(vehicleType)){
                truck.driving(distance);
            }
        }
    }
}
