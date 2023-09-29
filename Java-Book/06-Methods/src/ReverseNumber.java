import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String result = reverseNumber(number);

        System.out.printf("The number %d reverse to %d", number, Integer.parseInt(result));
    }

    public static String reverseNumber(int number){

        int lastDigit;
        String result = "";

        while (number > 0){
            lastDigit = number % 10;
            result += lastDigit;
            number /= 10;
        }

        return result;
    }
}
