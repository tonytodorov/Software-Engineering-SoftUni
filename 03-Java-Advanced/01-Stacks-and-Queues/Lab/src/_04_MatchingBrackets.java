import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_MatchingBrackets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);

            if (letter == '(') {
                stack.push(i);
            } else if (letter == ')') {
                int starIndex = stack.pop();
                String text = input.substring(starIndex, i + 1);
                System.out.println(text);
            }
        }
    }
}
