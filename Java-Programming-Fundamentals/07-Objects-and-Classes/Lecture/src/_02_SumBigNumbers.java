import java.math.BigInteger;
import java.util.Scanner;

public class _02_SumBigNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(scanner.nextLine());
        BigInteger secondNum = new BigInteger(scanner.nextLine());

        System.out.println(firstNum.add(secondNum));
    }
}
