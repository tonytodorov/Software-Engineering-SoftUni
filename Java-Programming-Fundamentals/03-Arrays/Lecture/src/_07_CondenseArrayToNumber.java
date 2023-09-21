import java.util.Arrays;
import java.util.Scanner;

public class _07_CondenseArrayToNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if(numbers.length - 1 == 0){
            System.out.println(numbers[0]);
            return;
        }

        int i = 0;
        int sum = 0;

        while (numbers.length - 1 > 0){

            int[] condensed = new int[numbers.length - 1];

            while (i < numbers.length - 1){
                condensed[i] = numbers[i] + numbers[i + 1];
                i++;
            }

            System.arraycopy(condensed, 0, numbers, 0, numbers.length - 1);

            i = 0;
            sum = condensed[0];
            numbers = condensed;
        }

        System.out.println(sum);
    }
}
