import java.util.Arrays;
import java.util.Scanner;

public class _01_NumberInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lowerBound = range[0];
        int upperBound = range[1];

        System.out.printf("Range: [%d...%d]%n", lowerBound, upperBound);

        String number = scanner.nextLine();

        while (true) {

            try {
                int num = Integer.parseInt(number);
                if (isNumberInRange(num , lowerBound, upperBound)) {
                    System.out.printf("Valid number: %d%n", num);
                    break;
                }

                System.out.printf("Invalid number: %d%n", num);
            } catch (NumberFormatException e) {
                System.out.printf("Invalid number: %s%n", number);
            }

            number = scanner.nextLine();
        }

    }

    private static boolean isNumberInRange(int num, int lowerBound, int upperBound) {
        return num >= lowerBound && num <= upperBound;
    }
}
