import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] tokens = input.split(", ");
            String action = tokens[0];
            String carNumber = tokens[1];

            if (action.equals("IN")) {
                parking.add(carNumber);
            } else {
                parking.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }

        for (String carNumber: parking) {
            System.out.println(carNumber);
        }
    }
}
