import java.util.Scanner;

public class _02_PoundsToDollars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double britishPound = Double.parseDouble(scanner.nextLine());
        double result = britishPound * 1.36;

        System.out.printf("%.3f", result);
    }
}
