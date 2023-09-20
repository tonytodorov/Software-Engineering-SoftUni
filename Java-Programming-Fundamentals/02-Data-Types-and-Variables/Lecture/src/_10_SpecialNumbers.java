import java.util.Scanner;

public class _10_SpecialNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int number = i;

            while (number > 0){
                int lastDigit = number % 10;
                sum += lastDigit;
                number /= 10;
            }

            if(sum == 5 || sum == 7 || sum == 11){
                System.out.printf("%d -> True%n", i);
            }else{
                System.out.printf("%d -> False%n", i);
            }

            sum = 0;
        }
    }
}
