package constructors;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            Car car;

            if (data.length > 1) {
                car = new Car(data[0], data[1], Integer.parseInt(data[2]));
            } else {
                car = new Car(data[0]);
            }

            System.out.println(car);
        }
    }
}
