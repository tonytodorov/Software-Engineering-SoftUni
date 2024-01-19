import java.util.Scanner;

public class _02_RepeatStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (String element : text) {
            int currentWordLength = element.length();
            result.append(element.repeat(currentWordLength));
        }

        System.out.println(result);
    }
}
