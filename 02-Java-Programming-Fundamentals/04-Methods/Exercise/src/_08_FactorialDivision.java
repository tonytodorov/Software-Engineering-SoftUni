import java.util.Scanner;

public class _08_FactorialDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        long factFirstNum = calculateFactorial(firstNum);
        long factSecondNum = calculateFactorial(secondNum);

        double result = 1.0 * factFirstNum / factSecondNum;
        System.out.printf("%.2f", result);
    }

    public static long calculateFactorial(int number){

        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
