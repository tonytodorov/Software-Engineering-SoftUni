import java.math.BigInteger;
import java.util.Scanner;

public class _03_BigFactorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int factorial = Integer.parseInt(scanner.nextLine());
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= factorial; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }
}
