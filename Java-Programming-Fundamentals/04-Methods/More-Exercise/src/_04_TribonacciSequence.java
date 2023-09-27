import java.util.Scanner;

public class _04_TribonacciSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long[] tribonacciSeq = tribonacciSeq(n);

        for (long num: tribonacciSeq) {
            System.out.printf("%d ", num);
        }
    }

    public static long[] tribonacciSeq(int n){

        if(n < 3){
            return new long[]{n};
        }

        long[] tribSeq = new long[n];

        tribSeq[0] = 1;
        tribSeq[1] = 1;
        tribSeq[2] = 2;

        for (int i = 3; i < n; i++) {
            tribSeq[i] = tribSeq[i - 1] + tribSeq[i - 2] + tribSeq[i - 3];
        }

        return tribSeq;
    }

}
