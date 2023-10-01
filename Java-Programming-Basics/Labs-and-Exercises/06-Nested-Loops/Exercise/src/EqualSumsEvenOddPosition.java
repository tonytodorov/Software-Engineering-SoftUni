import java.util.Scanner;

public class EqualSumsEvenOddPosition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1, number2, digit1, digit2, digit3, digit4, digit5, digit6, sumOddNumbers, sumEvenNumbers;

        number1 = Integer.parseInt(scanner.nextLine());
        number2 = Integer.parseInt(scanner.nextLine());


        for (int i = number1; i <= number2; i++) {

            digit1 = i / 100000 % 10;
            digit2 = i / 10000 % 10;
            digit3 = i / 1000 % 10;
            digit4 = i / 100 % 10;
            digit5 = i / 10 % 10;
            digit6 = i % 10;

            sumOddNumbers = digit1 + digit3 + digit5;
            sumEvenNumbers = digit2 + digit4 + digit6;

            if(sumOddNumbers == sumEvenNumbers){
                System.out.printf("%d ", i);
            }
        }
    }
}
