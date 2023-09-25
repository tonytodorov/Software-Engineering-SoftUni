import java.util.Scanner;

public class _11_MathOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());

        int result = calculateOperation(firstNum, operator, secondNum);
        System.out.println(result);
    }

    public static int calculateOperation(int firstNum, String operator, int secondNum) {

        int result = 0;

        if (operator.equals("/")) {
            if (secondNum != 0) {
               result = firstNum / secondNum;
            }
        } else if (operator.equals("*")) {
            result = firstNum * secondNum;
        } else if (operator.equals("+")) {
            result = firstNum + secondNum;
        } else if (operator.equals("-")) {
            result = firstNum - secondNum;
        }

        return result;
    }
}
