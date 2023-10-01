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

        int bombNumber = Integer.parseInt(bombPerformance[0]);
        int bombPower = Integer.parseInt(bombPerformance[1]);

        int bombIndex, bombIndexLeft, bombIndexRight;
        int removeElements;

        for (int i = 0; i < numbers.size(); i++) {

            if(numbers.get(i).equals(bombNumber)) {
                bombIndex = i;
                bombIndexLeft = bombIndex - bombPower;
                bombIndexRight = bombIndex + bombPower;

                if (bombIndexRight > numbers.size() - 1) {
                    bombIndexRight = numbers.size() - 1;
                }

                if (bombIndexLeft < 0) {
                    bombIndexLeft = 0;
                }

                removeElements = bombIndexRight - bombIndexLeft;
                numbers.remove(bombIndex);

                while (removeElements > 0) {
                    numbers.remove(bombIndexLeft);
                    removeElements--;
                }
            }
        }

        int sum = 0;

        for (int num: numbers) {
            sum += num;
        }

        System.out.println(sum);
    }
}
