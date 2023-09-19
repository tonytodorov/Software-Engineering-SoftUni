import java.util.Scanner;

public class LeftAndRightSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNumbers, numbers, firstSum = 0, secondSum = 0;
        numberOfNumbers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfNumbers; i++) {
            numbers = Integer.parseInt(scanner.nextLine());
            firstSum += numbers;
        }

        for (int j = 0; j < numberOfNumbers; j++) {
            numbers = Integer.parseInt(scanner.nextLine());
            secondSum += numbers;
        }

        if (firstSum == secondSum){
            System.out.printf("Yes, sum = %d", firstSum);
        }else{
            System.out.printf("No, diff = %d", Math.abs(secondSum - firstSum));
        }
    }
}
