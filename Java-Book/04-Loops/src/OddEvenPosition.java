import java.util.Scanner;

public class OddEvenPosition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, number , sumEvenNumbers = 0, sumOddNumbers = 0,
                oddMin = Integer.MAX_VALUE, evenMin = Integer.MAX_VALUE,
                oddMax = Integer.MIN_VALUE, evenMax = Integer.MIN_VALUE;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            number = Integer.parseInt(scanner.nextLine());

            if(i % 2 == 0){
                sumEvenNumbers += number;
                if(evenMin > number){
                    evenMin = number;
                }
                if(evenMax < number){
                    evenMax = number;
                }

            }else {
                sumOddNumbers += number;
                if(oddMin > number){
                    oddMin = number;
                }
                if(oddMax < number){
                    oddMax = number;
                }
            }
        }

        System.out.printf("Odd sum=%d,\nOdd min=%d,\nOdd max=%d,\n", sumOddNumbers, oddMin, oddMax);
        System.out.printf("Even sum=%d,\nEven min=%d,\nEven max=%d", sumEvenNumbers, evenMin, evenMax);
    }
}
