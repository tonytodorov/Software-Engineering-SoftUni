package raw.data;

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
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double firstTirePressure = Double.parseDouble(input[5]);
            int firstTireAge = Integer.parseInt(input[6]);
            double secondTirePressure = Double.parseDouble(input[7]);
            int secondTireAge = Integer.parseInt(input[8]);
            double thirdTirePressure = Double.parseDouble(input[9]);
            int thirdTireAge = Integer.parseInt(input[10]);
            double fourthTirePressure = Double.parseDouble(input[11]);
            int fourthTireAge = Integer.parseInt(input[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType,
                    firstTirePressure, firstTireAge, secondTirePressure, secondTireAge,
                    thirdTirePressure, thirdTireAge, fourthTirePressure, fourthTireAge);

            cars.add(car);
        }

        String command = scanner.nextLine();

        if ("fragile".equals(command)) {
            for (Car car: cars) {
                if (car.getCargoType().equals(command)) {
                    if (car.getFirstTirePressure() < 1 || car.getSecondTirePressure() < 1 ||
                            car.getThirdTirePressure() < 1 || car.getFourthTirePressure() < 1) {
                        System.out.println(car.getModel());
                    }
                }
            }
        } else {
            for (Car car: cars) {
                if (car.getEnginePower() > 250) {
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
