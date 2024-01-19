import java.util.Scanner;

public class _10_TopNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < number; i++) {

            boolean isSumOfDigitsDivisible8 = isSumOfDigitsDivisible8(i);
            boolean isNumContainsOddDigit = isNumContainsOddDigit(i);

            if (isSumOfDigitsDivisible8 && isNumContainsOddDigit) {
                System.out.println(i);
            }
        }
    }

    public static boolean isSumOfDigitsDivisible8(int num){

        int sum = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            sum += lastDigit;
            num /= 10;
        }

        return sum % 8 == 0;
    }


    public static boolean isNumContainsOddDigit(int num){

        while (num > 0){
            int lastDigit = num % 10;

            if(lastDigit % 2 != 0){
                return true;
            }

            num /= 10;
        }

        return false;
    }

}
