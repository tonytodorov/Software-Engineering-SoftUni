import java.math.BigDecimal;
import java.util.Scanner;

public class _03_ExactSumOfRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = BigDecimal.ZERO;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            BigDecimal numbers = new BigDecimal(input);
            sum = sum.add(numbers);
        }
        System.out.println(sum);
    }
}
