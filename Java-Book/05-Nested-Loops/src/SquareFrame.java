import java.util.Scanner;

public class SquareFrame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String firstAndLastRow = "+";

        for (int col = 0; col < n - 2; col++) {
            firstAndLastRow += " -";
        }
        firstAndLastRow += " +";

        System.out.println(firstAndLastRow);

        String middleRows = "|";

        for (int col = 0; col < n -2; col++) {
            middleRows += " -";
        }
        middleRows += " |";
        System.out.println(middleRows);

        for (int i = 0; i < n- 2; i++) {
            System.out.println(middleRows);
        }

        System.out.println(firstAndLastRow);

    }
}
