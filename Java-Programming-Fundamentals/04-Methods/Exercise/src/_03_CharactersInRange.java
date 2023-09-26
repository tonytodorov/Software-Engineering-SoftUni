import java.util.Scanner;

public class _03_CharactersInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLetter = scanner.nextLine();
        String secondLetter = scanner.nextLine();

        String[] result = characters(firstLetter, secondLetter);

        for (String text : result) {
            System.out.printf("%s ", text);
        }
    }

    public static String[] characters(String firstLetter, String secondLetter){

        char firstL = firstLetter.charAt(0);
        char secondL = secondLetter.charAt(0);

        int minLetter = Math.min(firstL, secondL);
        int maxLetter = Math.max(firstL, secondL);

        String[] result = new String[maxLetter - minLetter - 1];

        int count = 0;

        for (int i = minLetter + 1; i < maxLetter; i++) {
            result[count] = String.valueOf((char) i);
            count++;
        }

        return result;
    }
}
