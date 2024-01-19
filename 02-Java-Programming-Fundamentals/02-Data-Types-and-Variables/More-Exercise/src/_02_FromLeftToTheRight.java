import java.util.Scanner;

public class _02_FromLeftToTheRight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] array = new int[n];
        int result;

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            String[] part = text.split(" ");
            long leftNumber = Long.parseLong(part[0]);
            long rightNumber = Long.parseLong(part[1]);

            long biggestNumber = Math.max(leftNumber, rightNumber);
            long absValue = Math.abs(biggestNumber);

            result = sumDigits(absValue);
            array[i] = result;
        }

        for (int num: array) {
            System.out.println(num);
        }
    }

    public static int sumDigits(long number){

        int sum = 0;

        while (number > 0){
            long lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }

        return sum;
    }
}
