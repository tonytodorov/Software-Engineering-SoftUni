import java.util.Scanner;

public class RhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row < n; row++) {
            System.out.print(" ");
            System.out.print("*");
            System.out.println();
            for (int j = 0; j <= row; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) {
            System.out.print(" ");
            System.out.print("* ");
        }
        
    }
}
