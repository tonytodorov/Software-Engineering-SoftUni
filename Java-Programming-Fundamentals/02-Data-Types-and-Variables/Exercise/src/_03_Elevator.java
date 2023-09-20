import java.util.Scanner;

public class _03_Elevator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int persons = Integer.parseInt(scanner.nextLine());
        int capacityOfElevator = Integer.parseInt(scanner.nextLine());

        double result = Math.ceil(1.0 * persons / capacityOfElevator);
        System.out.printf("%.0f", result);
    }
}
