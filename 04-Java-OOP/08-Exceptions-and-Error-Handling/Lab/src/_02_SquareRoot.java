import java.util.Scanner;

public class _02_SquareRoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());
            System.out.printf("%.2f%n", Math.sqrt(number));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
