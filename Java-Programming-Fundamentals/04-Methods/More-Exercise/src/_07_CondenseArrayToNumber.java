import java.util.Arrays;
import java.util.Scanner;

public class _07_CondenseArrayToNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] temp = new int[numbers.length - 1];

        while (numbers.length - 1 > 0){

            for (int i = 0; i < temp.length; i++) {
                temp[i] = numbers[i] + numbers[i + 1];
            }

            numbers = temp;
            temp = new int[numbers.length - 1];
        }

        System.out.println(numbers[0]);
    }
}
