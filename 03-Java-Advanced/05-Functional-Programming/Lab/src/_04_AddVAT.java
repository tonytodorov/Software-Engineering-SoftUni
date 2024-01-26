import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _04_AddVAT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        Function<String, Double> addVat = price -> Double.parseDouble(price) * 1.2;

        Arrays.stream(scanner.nextLine().split(", "))
                .map(addVat)
                .forEach(value -> System.out.printf("%.2f%n", value));

    }
}
