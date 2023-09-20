import java.util.Scanner;

public class _05_PrintPartOfASCIITable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound, upperBound;
        lowerBound = Integer.parseInt(scanner.nextLine());
        upperBound = Integer.parseInt(scanner.nextLine());

        for (int i = lowerBound; i <= upperBound; i++) {
            System.out.print((char) i + " ");
        }
    }
}
