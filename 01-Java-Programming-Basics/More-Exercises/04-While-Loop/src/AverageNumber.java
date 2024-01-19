import java.util.Scanner;

public class AverageNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, number, sum = 0;
        double averageResult;
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(scanner.nextLine());
            sum += number;
        }

        averageResult = (double)sum / n;
        System.out.printf("%.2f", averageResult);
    }
}
