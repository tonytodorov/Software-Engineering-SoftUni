import java.util.Scanner;

public class _01_Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        int sum = 0;

        for (int num: array) {
            System.out.printf("%d ", num);
            sum += num;
        }

        System.out.printf("%n%d", sum);
    }
}
