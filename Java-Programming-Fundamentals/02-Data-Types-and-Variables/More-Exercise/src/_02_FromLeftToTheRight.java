import java.util.Scanner;

public class _02_FromLeftToTheRight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double result;

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            String[] part = text.split(" ");
            double leftNumber = Double.parseDouble(part[0]);
            double rightNumber = Double.parseDouble(part[1]);

            if (leftNumber > rightNumber){
                result = sumDigits(leftNumber);
            } else {
                result = sumDigits(rightNumber);
            }

            System.out.printf("%.0f%n", result);
        }
    }

    public static int sumDigits(double number){

        int sum = 0;

        while (number > 0){
            double lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }

        return sum;
    }
}
