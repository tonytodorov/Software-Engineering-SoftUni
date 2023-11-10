import java.util.Locale;
import java.util.Scanner;

public class _08_LettersChangeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] data = input.split("\\s+");

        double totalSum = 0;

        for (String datum : data) {
            String currentText = datum;

            char firstLetter = currentText.charAt(0);
            char lastLetter = currentText.charAt(currentText.length() - 1);

            currentText = currentText.replace(String.valueOf(firstLetter), "");
            currentText = currentText.replace(String.valueOf(lastLetter), "");

            double number = Double.parseDouble(currentText);
            int position;

            if (Character.isUpperCase(firstLetter)) {
                position = letterPosition(firstLetter);
                double divide = number / position;
                totalSum += divide;
            } else {
                position = letterPosition(firstLetter);
                double multiply = number * position;
                totalSum += multiply;
            }

            if (Character.isUpperCase(lastLetter)) {
                position = letterPosition(lastLetter);
                totalSum -= position;
            } else {
                position = letterPosition(lastLetter);
                totalSum += position;
            }
        }

        System.out.printf("%.2f", totalSum);
    }


    public static int letterPosition(char searchedLetter) {

        int position = 0;

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String text = String.valueOf(searchedLetter);
        text = text.toLowerCase(Locale.ROOT);

        for (int i = 0; i < alphabet.length(); i++) {
            char alphabetLetter = alphabet.charAt(i);
            String currentLetter = String.valueOf(alphabetLetter);

            if (text.equals(currentLetter)) {
                position = i + 1;
                break;
            }
        }

        return position;
    }
}
