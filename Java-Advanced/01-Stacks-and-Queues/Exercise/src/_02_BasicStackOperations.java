import java.util.*;
import java.util.stream.Collectors;

public class _02_BasicStackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int popElements = input[1];
        int containsNum = input[2];

        List<Integer> nums = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer num : nums) {
            numbers.push(num);
        }

        for (int i = 0; i < popElements; i++) {
            numbers.pop();
        }

        if (numbers.contains(containsNum)) {
            System.out.println("true");
        } else if (!numbers.isEmpty()){
            System.out.println(numbers.peek());
        } else {
            System.out.println("0");
        }
    }
}
