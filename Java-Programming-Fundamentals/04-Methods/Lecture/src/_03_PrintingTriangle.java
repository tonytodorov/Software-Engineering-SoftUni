import java.util.Scanner;

public class _03_PrintingTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        upperSide(n);
        downSide(n);
    }

    public static void upperSide(int n){

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.printf("%d ", col);
            }
            System.out.println();
        }
    }

    public static void downSide(int n){

        for (int row = n - 1; row >= 0; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.printf("%d ", col);
            }
            System.out.println();
        }
    }
}
