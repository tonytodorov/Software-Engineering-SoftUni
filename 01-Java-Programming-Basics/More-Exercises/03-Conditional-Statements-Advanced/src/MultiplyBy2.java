import java.util.Scanner;

public class MultiplyBy2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());

        while (number > 0){
            number *= 2;
            System.out.printf("Result: %.2f%n", number);

            number = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("Negative number!");
    }
}
