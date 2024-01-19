import java.util.Scanner;

public class _10_MultiplyEvensByOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        int sumOddDigits = sumOddDigits(number);
        int sumEvenDigits = sumEvenDigits(number);

        int result = sumOddDigits * sumEvenDigits;
        System.out.println(result);
    }

    public static int sumOddDigits(int number) {

        int sumOddDigits = 0;

        while (number > 0){
            int lastDigit = number % 10;

            if (lastDigit % 2 != 0) {
                sumOddDigits += lastDigit;
            }

            number /= 10;
        }

        return sumOddDigits;
    }

    public static int sumEvenDigits(int number) {

        int sumEvenDigits = 0;

        while (number > 0) {
            int lastDigit = number % 10;

            if(lastDigit % 2 == 0){
                sumEvenDigits += lastDigit;
            }

            number /= 10;
        }

        return sumEvenDigits;
    }
}
