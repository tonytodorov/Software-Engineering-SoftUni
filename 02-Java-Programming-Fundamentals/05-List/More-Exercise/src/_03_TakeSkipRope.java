import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_TakeSkipRope {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        List<Integer> numbers = extractNumbers(text);
        List<String> letters = extractText(text);

        List<Integer> takeList = takeList(numbers);
        List<Integer> skipList = skipList(numbers);

        String result = "";

        for (int i = 0; i < takeList.size(); i++) {

            int takeCount = takeList.get(i);
            int skipCount = skipList.get(i);

            String takeResult = takeCount(letters, takeCount);
            result += takeResult;
            skipCount(letters, skipCount);

        }

        System.out.println(result);
    }


    public static List<Integer> extractNumbers(String text) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            if (letter >= 48 && letter <= 57) {
                int number = Integer.parseInt(String.valueOf(letter));
                numbers.add(number);
            }
        }

        return numbers;
    }

    public static List<String> extractText(String text) {

        List<String> letters = new ArrayList<>();
        String textWithoutNumbers = text.replaceAll("\\d", "");

        for (int i = 0; i < textWithoutNumbers.length(); i++) {
            char letter = textWithoutNumbers.charAt(i);
            letters.add(String.valueOf(letter));
        }

        return letters;
    }


    public static List<Integer> takeList(List<Integer> numbers) {

        List<Integer> takeList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            }
        }

        return takeList;
    }

    public static List<Integer> skipList(List<Integer> numbers) {

        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 != 0) {
                skipList.add(numbers.get(i));
            }
        }

        return skipList;
    }

    public static String takeCount(List<String> letters, int takeCount) {

        String result = "";

        for (int j = 0; j < takeCount; j++) {
            if (j > letters.size() - 1) {
                break;
            }
            result += letters.get(j);
        }

        for (int k = 0; k < takeCount; k++) {
            if (letters.size() == 0) {
                break;
            }

            letters.remove(k);
            k = - 1;
            takeCount--;
        }

        return result;
    }

    public static void skipCount(List<String> letters, int skipCount) {

        for (int n = 0; n < skipCount; n++) {
            if (letters.size() == 0) {
                break;
            }

            letters.remove(n);
            n = - 1;
            skipCount--;
        }
    }
}
