import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, number1, number2, sum, diff = 0, lastSum = 0;
        n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            number1 = Integer.parseInt(scanner.nextLine());
            number2 = Integer.parseInt(scanner.nextLine());
            sum = number1 + number2;

            if (i > 1){
                diff = Math.abs(lastSum - sum);
            }
            lastSum = sum;
        }
        if (diff == 0){
            System.out.printf("Yes, value=%d", lastSum);
        }else{
            System.out.printf("No, maxdiff=%d", diff);
        }
    }
}
