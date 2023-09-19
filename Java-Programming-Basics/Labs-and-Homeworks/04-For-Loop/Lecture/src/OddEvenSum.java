import java.util.Scanner;

public class OddEvenSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNumbers, numbers, sumForEvenNumbers = 0, sumForOddNumbers = 0;
        numberOfNumbers = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfNumbers; i++) {
            numbers = Integer.parseInt(scanner.nextLine());
            if(i % 2 == 0){
                sumForEvenNumbers += numbers;
            }else{
                sumForOddNumbers += numbers;
            }
        }

        if(sumForEvenNumbers == sumForOddNumbers){
            System.out.printf("Yes\nSum = %d", sumForEvenNumbers);
        }else{
            System.out.printf("No\nDiff = %d", Math.abs(sumForEvenNumbers - sumForOddNumbers));
        }

    }
}
