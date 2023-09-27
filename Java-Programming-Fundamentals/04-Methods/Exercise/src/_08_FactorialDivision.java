import java.util.Scanner;

public class _08_FactorialDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double result = divisibleNumber(firstNum, secondNum);
        System.out.printf("%.2f", result);
    }

    public static int factorial(int num){

        int factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static double divisibleNumber(int firstNum, int secondNum){
        return 1.0 * factorial(firstNum) / factorial(secondNum);
    }
}
