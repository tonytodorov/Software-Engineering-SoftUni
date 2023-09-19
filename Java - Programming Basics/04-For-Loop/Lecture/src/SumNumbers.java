import java.util.Scanner;

public class SumNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOFNumbers, numbers, sum = 0;
        numberOFNumbers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOFNumbers; i++) {
            numbers = Integer.parseInt(scanner.nextLine());
            sum += numbers;
        }
        System.out.println(sum);
    }
}
