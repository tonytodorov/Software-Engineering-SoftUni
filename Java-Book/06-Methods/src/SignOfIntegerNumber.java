import java.util.Scanner;

public class SignOfIntegerNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.printf("The number %d is %s.", number, signOfNumber(number));
    }

    public static String signOfNumber(int num){

        String numSign = "";

        if(num < 0){
            numSign = "negative";
        }else if(num > 0){
            numSign = "positive";
        }else {
            numSign = "zero";
        }

        return numSign;
    }
}
