import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_BombNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] bombPerformance = scanner.nextLine().split(" ");

        int bomb = Integer.parseInt(bombPerformance[0]);
        int bombPower = Integer.parseInt(bombPerformance[1]);

        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb);
            int startIndex = Math.max(0, index - bombPower);

            for (int i = startIndex; i < index; i++) {
                numbers.remove(startIndex);
            }

            index = numbers.indexOf(bomb);
            int endIndex = Math.min(index + bombPower, numbers.size() - 1);

            for (int i = index; i <= endIndex; i++) {
                numbers.remove(index);
            }
        }

        int sum = 0;

        for (Integer number: numbers) {
            sum += number;
        }

        System.out.println(sum);
    }
}
