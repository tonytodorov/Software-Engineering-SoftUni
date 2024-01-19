import java.util.Scanner;

public class _03_RecursiveFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long result = fib(n);
        System.out.println(result);

    }

    public static long fib(int n){

        long result = 1;
        long firstNum = 1;
        long secondNum = 1;

        for (int i = 2; i < n; i++) {
            result = firstNum + secondNum;

            secondNum = firstNum;
            firstNum = result;
        }

        return result;
    }
}
