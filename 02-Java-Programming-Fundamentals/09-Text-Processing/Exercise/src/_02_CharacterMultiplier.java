import java.util.Scanner;

public class _02_CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");

        String firstText = text[0];
        String secondText = text[1];

        int result = sum(firstText, secondText);

        System.out.println(result);
    }


    public static int sum(String firstText, String secondText) {

        int firstTextLength = firstText.length();
        int secondTextLength = secondText.length();

        int smallestLength = Math.min(firstTextLength, secondTextLength);

        int totalSum = 0;

        for (int i = 0; i < smallestLength; i++) {
            char firstLetter = firstText.charAt(i);
            char secondLetter = secondText.charAt(i);

            totalSum += ((int)firstLetter * secondLetter);
        }

        firstText = firstText.substring(smallestLength);
        secondText = secondText.substring(smallestLength);

        for (int i = 0; i < firstText.length(); i++) {
            char letter = firstText.charAt(i);
            totalSum += letter;
        }

        for (int i = 0; i < secondText.length(); i++) {
            char letter = secondText.charAt(i);
            totalSum += letter;
        }

        return totalSum;
    }
}
