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
            String[] tokens = scanner.nextLine().split("\\s+");

            String operation = tokens[0];
            String type = tokens[1];
            double quantity = Double.parseDouble(tokens[2]);

            if (operation.equals("Drive")) {
                drive(car, truck, type, quantity);
            } else if (operation.equals("Refuel")){
                refuel(car, truck, type, quantity);
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }


    private static void drive(Car car, Truck truck, String type, double quantity) {
        if (type.equals("Car")) {
            car.drive(quantity);
        } else {
            truck.drive(quantity);
        }
    }

    private static void refuel(Car car, Truck truck, String type, double quantity) {
        if (type.equals("Car")) {
            car.refuel(quantity);
        } else {
            truck.refuel(quantity);
        }
    }
}
