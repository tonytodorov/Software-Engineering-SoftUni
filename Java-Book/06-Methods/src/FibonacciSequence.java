import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        // Recursion
        for (int i = 0; i < n; i++) {
            System.out.println(fibRecursion(i) + " ");
        }

        // DP
        for (int i = 0; i < n; i++) {
            System.out.println(fibDP(i) + " ");
        }


    }

    public static long fibRecursion(int n){

        if(n <= 1){
            return n;
        }

        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    public static long fibDP(int n){

        long[] array = new long[n + 2];

        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }
}
