import java.util.Scanner;

public class _06_RecursiveFibonacci {

    private static long[] fibArray = new long[100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long result = fibonacci(n);

        System.out.println(result);
    }

    public static long fibonacci(int n) {

        long fibValue;

        if (n <= 1) {
            return 1;
        } else if (fibArray[n] != 0) {
            return fibArray[n];
        } else {
            fibValue = fibonacci(n - 1) + fibonacci(n - 2);
            fibArray[n] = fibValue;
            return fibValue;
        }
    }
}
