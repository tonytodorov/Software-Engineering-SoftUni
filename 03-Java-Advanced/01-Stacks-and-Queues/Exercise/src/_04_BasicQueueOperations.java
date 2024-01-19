import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> nums = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (Integer num : nums) {
            numbers.offer(num);
        }

        int numberOfPollElements = input[1];
        int containNumber = input[2];

        for (int i = 0; i < numberOfPollElements; i++) {
            numbers.poll();
        }

        if (numbers.contains(containNumber)) {
            System.out.println("true");
        } else if (numbers.isEmpty()) {
            System.out.println("0");
        } else {
            int minValue = Integer.MAX_VALUE;

            for (int i = 0; i < numbers.size(); i++) {
                int currentNum = numbers.poll();
                numbers.offer(currentNum);

                if (currentNum < minValue) {
                    minValue = currentNum;
                }
            }

            System.out.println(minValue);
        }
    }
}
