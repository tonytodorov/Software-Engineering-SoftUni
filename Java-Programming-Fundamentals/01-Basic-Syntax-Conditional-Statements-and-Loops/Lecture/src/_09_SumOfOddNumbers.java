import java.util.Scanner;

public class _09_SumOfOddNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int startNumber = 1, sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.println(startNumber);
            sum += startNumber;
            startNumber += 2;
        }

        System.out.printf("Sum: %d", sum);
    }
}
