import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(factorial(number));

    }

    public static BigInteger factorial(int n){

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

}
