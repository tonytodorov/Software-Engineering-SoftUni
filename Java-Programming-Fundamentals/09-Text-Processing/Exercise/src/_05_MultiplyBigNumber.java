import java.math.BigInteger;
import java.util.Scanner;

public class _05_MultiplyBigNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        BigInteger firstNum = new BigInteger(firstNumber);
        int secondNum = Integer.parseInt(secondNumber);

        BigInteger result = firstNum.multiply(BigInteger.valueOf(secondNum));
        System.out.println(result);
    }
}
