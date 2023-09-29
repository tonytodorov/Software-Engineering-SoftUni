import java.util.Scanner;

public class FibonacciElement {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

//        long result = fib(n);
//        System.out.println(result);

        long resultN = fibN(n);
        System.out.println(resultN);

    }

    // Recursion method to find element
    public static int fib(int n){

        if(n <= 2){
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }


    // Iterative method to find element
    public static long fibN(int n){
        long fn = 1;
        long fn_1 = 1;
        long fn_2 = 1;

        for (int i = 2; i < n; i++) {
            fn = fn_1 + fn_2;

            fn_2 = fn_1;
            fn_1 = fn;
        }

        return fn;
    }



}
