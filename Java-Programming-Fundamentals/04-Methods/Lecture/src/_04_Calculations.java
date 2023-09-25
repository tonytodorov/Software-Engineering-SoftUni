import java.util.Scanner;

public class _04_Calculations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        int result = 0;

        if (operation.equals("add")) {
            result = add(firstNum, secondNum);
        } else if (operation.equals("multiply")) {
            result = multiply(firstNum, secondNum);
        } else if (operation.equals("subtract")) {
            result = subtract(firstNum, secondNum);
        } else if (operation.equals("divide")) {
            result = divide(firstNum, secondNum);
        }

        System.out.println(result);
    }

    public static int add(int firstNum, int secondNum){
        return firstNum + secondNum;
    }

    public static int multiply(int firstNum, int secondNum){
        return firstNum * secondNum;
    }

    public static int subtract(int firstNum, int secondNum){
        return firstNum - secondNum;
    }

    public static int divide(int firstNum, int secondNum){
        return firstNum / secondNum;
    }
}
