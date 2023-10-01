import java.util.Scanner;

public class HalfSumElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfNumbers, numbers, sum = 0, maxNumber = Integer.MIN_VALUE;
        numberOfNumbers = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfNumbers; i++) {
            numbers = Integer.parseInt(scanner.nextLine());
            maxNumber = Math.max(maxNumber, numbers);
            sum += numbers;
        }

        int sumWithoutMaxNumber = Math.abs(sum - maxNumber);

        if(sumWithoutMaxNumber == maxNumber){
            System.out.printf("Yes\nSum = %d", maxNumber);
        }else{
            System.out.printf("No\nDiff = %d", Math.abs(maxNumber - sumWithoutMaxNumber));
        }
    }
}
