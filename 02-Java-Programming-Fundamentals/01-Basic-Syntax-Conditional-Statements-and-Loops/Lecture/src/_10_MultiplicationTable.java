import java.util.Scanner;

public class _10_MultiplicationTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multiplier = 1;

        for (int i = 0; i < 10; i++) {
            int result = number * multiplier;
            System.out.printf("%d X %d = %d%n", number, multiplier, result);
            multiplier++;
        }
    }
}
