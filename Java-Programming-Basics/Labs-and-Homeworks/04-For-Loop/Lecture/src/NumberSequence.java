import java.util.Scanner;

public class NumberSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNumbers,
                numbers,
                max = Integer.MIN_VALUE,
                min = Integer.MAX_VALUE;

        numberOfNumbers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfNumbers; i++){
            numbers = Integer.parseInt(scanner.nextLine());
            max = Math.max(max, numbers);
            min = Math.min(min, numbers);
        }
        System.out.println("Max number: " + max);
        System.out.println("Min number: " + min);
    }
}
