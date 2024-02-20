import java.util.Scanner;

public class _01_RhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printRhombusUpperSide(n);
        printRhombusDownSide(n);
    }

    public static void printRhombusUpperSide(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void printRhombusDownSide(int n) {

        for (int i = n; i > 0; i--) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j < i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
