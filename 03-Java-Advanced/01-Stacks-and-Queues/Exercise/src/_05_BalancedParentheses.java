import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_BalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isParenthesesBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char firstParentheses = input.charAt(i);

            if (firstParentheses == '{' || firstParentheses == '(' || firstParentheses == '[') {
                stack.push(firstParentheses);
            } else {
                String firstPar = String.valueOf(stack.peek());
                String secondPar = String.valueOf(firstParentheses);

                String result = firstPar + secondPar;

                if (result.equals("()") || result.equals("[]") || result.equals("{}")) {
                    stack.pop();
                } else {
                    isParenthesesBalanced = true;
                    break;
                }
            }
        }

        if (isParenthesesBalanced) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
