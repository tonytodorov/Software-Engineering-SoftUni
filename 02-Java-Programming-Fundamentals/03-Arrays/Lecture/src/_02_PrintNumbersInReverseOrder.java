import java.util.Scanner;

public class _02_PrintNumbersInReverseOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            numbers[numbers.length - i - 1] = number;
        }

        for (int num: numbers) {
            System.out.printf("%d ", num);
        }
    }
}
