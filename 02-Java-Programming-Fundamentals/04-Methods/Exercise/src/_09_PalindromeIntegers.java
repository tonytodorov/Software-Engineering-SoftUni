import java.util.Scanner;

public class _09_PalindromeIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        while (!text.equals("END")){
            int number = Integer.parseInt(text);
            int reversedNumber = reverseNumber(number);

            boolean isNumbersEquals = number == reversedNumber;

            if (isNumbersEquals) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            text = scanner.nextLine();
        }
    }

    public static int reverseNumber(int num){

        StringBuilder text = new StringBuilder();

        while (num > 0) {
            int lastDigit = num % 10;
            text.append(lastDigit);
            num /= 10;
        }

        return Integer.parseInt(text.toString());
    }
}
