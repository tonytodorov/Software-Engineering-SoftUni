import java.util.Scanner;

public class _07_RecursiveFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if (n < 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
