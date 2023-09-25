import java.util.Scanner;

public class _01_SignOfInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        String result = signOfInteger(number);
        System.out.printf("The number %d is %s.", number, result);

    }

    public static String signOfInteger(int number){

        String sign = "";

        if(number > 0) {
            sign = "positive";
        } else if (number < 0) {
            sign = "negative";
        } else {
            sign = "zero";
        }

        return sign;
    }
}
