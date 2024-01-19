import java.util.Arrays;
import java.util.Scanner;

public class _05_TopIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isTopInteger = false;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {

                if(numbers[i] < numbers[j]){
                    isTopInteger = false;
                    break;
                }

                isTopInteger = true;
            }

            if(isTopInteger){
                System.out.printf("%d ", numbers[i]);
            }

            isTopInteger = false;
        }

        System.out.print(numbers[numbers.length - 1]);
    }
}
