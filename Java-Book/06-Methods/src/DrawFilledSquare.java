import java.util.Scanner;

public class DrawFilledSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String firstRow = repeatString("-", n * 2);
        System.out.println(firstRow);

        for (int i = 0; i < n - 2; i++) {
            String middleRow = repeatString("-", 1) +
                    repeatString("\\/", n - 1) +
                    repeatString("-", 1);
            System.out.println(middleRow);
        }

        String lastRow = repeatString("-", n * 2);
        System.out.println(lastRow);
    }

    public static String repeatString(String symbol, int n){

        String text = "";
        for (int i = 0; i < n; i++) {
            text += symbol;
        }

        return text;
    }
}
