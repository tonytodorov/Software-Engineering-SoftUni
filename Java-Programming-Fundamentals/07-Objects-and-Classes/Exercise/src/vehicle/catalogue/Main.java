package vehicle.catalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Vehicle> vehicleList = new ArrayList<>();

        while (!command.equals("End")) {

            String[] tokens = command.split(" ");

            String typeOfVehicle = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);

            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsepower);
            vehicleList.add(vehicle);

            command = scanner.nextLine();
        }

        String modelOfVehicle = scanner.nextLine();

        while (!modelOfVehicle.equals("Close the Catalogue")) {

            boolean isVehicleExisting = isVehicleExisting(vehicleList, modelOfVehicle);

            if (isVehicleExisting) {
               Vehicle vehicle = getVehicle(vehicleList, modelOfVehicle);
                System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n",
                        vehicle.getTypeOfVehicleWithUpperCase(),
                        vehicle.getModel(),
                        vehicle.getColor(),
                        vehicle.getHorsepower());
            }

            modelOfVehicle = scanner.nextLine();
        }

        double averageCarsHorsepower = averageCarsHorsepower(vehicleList);
        double averageTrucksHorsepower = averageTruckHorsepower(vehicleList);

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarsHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageTrucksHorsepower);
    }


    public static boolean isVehicleExisting(List<Vehicle> vehicleList, String modelOfVehicle) {

        for (Vehicle vehicle: vehicleList) {
            if (vehicle.getModel().equals(modelOfVehicle)) {
                return true;
            }
        }

        return false;
    }

    public static Vehicle getVehicle(List<Vehicle> vehicleList, String modelOfVehicle) {

        Vehicle currentVehicle = null;

        for (Vehicle vehicle: vehicleList) {
            if (vehicle.getModel().equals(modelOfVehicle)) {
                currentVehicle = vehicle;
                break;
            }
        }

        return currentVehicle;
    }

    public static double averageCarsHorsepower(List<Vehicle> vehicleList) {

        double averageCarsHorsepower = 0.00;
        int countCars = 0;

        for (Vehicle vehicle: vehicleList) {
            if (vehicle.getTypeOfVehicle().equals("car")) {
                countCars += 1;
                averageCarsHorsepower += vehicle.getHorsepower();
            }
        }

        if (countCars == 0) {
            return 0;
        }

        return averageCarsHorsepower / countCars;
    }

    public static double averageTruckHorsepower(List<Vehicle> vehicleList) {

        double averageTrucksHorsepower = 0.00;
        int countTrucks = 0;

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getTypeOfVehicle().equals("truck")) {
                countTrucks += 1;
                averageTrucksHorsepower += vehicle.getHorsepower();
            }
        }

        if (countTrucks == 0) {
            return 0;
        }

        return averageTrucksHorsepower / countTrucks;
    }
}

