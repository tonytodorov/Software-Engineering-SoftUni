import java.util.Scanner;

public class _06_StrongNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int currentNumber = number;
        int sum = 1, totalSum = 0;

        while (currentNumber > 0){
            int lastDigit = currentNumber % 10;

            for (int i = 1; i <= lastDigit; i++) {
                sum *= i;
            }

            totalSum += sum;
            sum = 1;
            currentNumber /= 10;
        }

        if(totalSum == number){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
