import java.util.Scanner;

public class _02_AsciiSumator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstSign = scanner.nextLine();
        String secondSign = scanner.nextLine();

        char lowerBound = firstSign.charAt(0);
        char upperBound = secondSign.charAt(0);

        String text = scanner.nextLine();

        int totalSum = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentLetter = text.charAt(i);

            if (currentLetter > lowerBound && currentLetter < upperBound) {
                totalSum += currentLetter;
            }
        }

        System.out.println(totalSum);
    }
}
