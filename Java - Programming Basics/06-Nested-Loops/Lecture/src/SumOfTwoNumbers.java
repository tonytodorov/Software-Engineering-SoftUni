import java.util.Scanner;

public class SumOfTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber, secondNumber, magicNumber, countCombo = 0;

        firstNumber = Integer.parseInt(scanner.nextLine());
        secondNumber = Integer.parseInt(scanner.nextLine());
        magicNumber = Integer.parseInt(scanner.nextLine());

        for (int i = firstNumber; i <= secondNumber ; i++) {
            for (int j = firstNumber; j <= secondNumber ; j++) {
                countCombo++;
                if(i + j == magicNumber){
                    System.out.printf("Combination N:%d (%d + %d = %d)", countCombo, i, j, magicNumber);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", countCombo, magicNumber);
    }
}
