import java.util.Arrays;
import java.util.Scanner;

public class _07_MaxSequenceOfEqualElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int currentElement = 0;
        int currentLength = 1;
        int bestLength = 1;

        for (int i = 0; i < numbers.length - 1; i++) {

            if(numbers[i] == numbers[i + 1]){
                currentLength++;
            }else{
                currentLength = 1;
            }

            if(currentLength > bestLength){
                bestLength = currentLength;
                currentElement = numbers[i];
            }
        }

        int[] result = new int[bestLength];
        Arrays.fill(result, currentElement);

        for (int num: result) {
            System.out.printf("%d ", num);
        }
    }
}
