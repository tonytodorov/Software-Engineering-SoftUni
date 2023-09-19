import java.util.Scanner;

public class BarcodeGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber, secondNumber, firstNumberDigit1,
                firstNumberDigit2, firstNumberDigit3, firstNumberDigit4,
                secondNumberDigit1, secondNumberDigit2, secondNumberDigit3, secondNumberDigit4;

        firstNumber = Integer.parseInt(scanner.nextLine());
        secondNumber = Integer.parseInt(scanner.nextLine());


        firstNumberDigit1 = firstNumber / 1000 % 10;
        firstNumberDigit2 = firstNumber / 100 % 10;
        firstNumberDigit3 = firstNumber / 10 % 10;
        firstNumberDigit4 = firstNumber % 10;

        secondNumberDigit1 = secondNumber / 1000 % 10;
        secondNumberDigit2 = secondNumber / 100 % 10;
        secondNumberDigit3 = secondNumber / 10 % 10;
        secondNumberDigit4 = secondNumber % 10;

        for (int i = firstNumberDigit1; i <= secondNumberDigit1; i++) {
            if(i % 2 != 0){
                for (int j = firstNumberDigit2; j <= secondNumberDigit2; j++) {
                    if(j % 2 != 0){
                        for (int k = firstNumberDigit3; k <= secondNumberDigit3; k++) {
                            if(k % 2 != 0){
                                for (int l = firstNumberDigit4; l <= secondNumberDigit4; l++) {
                                    if(l % 2 != 0){
                                        System.out.printf("%d%d%d%d ", i, j, k, l);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
