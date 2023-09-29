import java.util.Scanner;

public class LastNumberName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int result = lastDigit(number);

        System.out.printf("%s", lastDigitName(result));
    }

    public static int lastDigit(int number){
        return number % 10;
    }

    public static String lastDigitName(int number){

        String result = "";

        if(number == 0){
            result = "zero";
        }else if(number == 1){
            result = "one";
        }else if(number == 2){
            result = "two";
        }else if(number == 3){
            result = "three";
        }else if(number == 4){
            result = "four";
        }else if(number == 5){
            result = "five";
        }else if(number == 6){
            result = "six";
        }else if(number == 7){
            result = "seven";
        }else if(number == 8){
            result = "eight";
        }else if(number == 9){
            result = "nine";
        }

        return result;
    }
}
