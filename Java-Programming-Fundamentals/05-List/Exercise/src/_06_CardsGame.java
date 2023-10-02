import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _06_CardsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstPlayerCards.size() > 0 && secondPlayerCards.size() > 0) {

            int firstPlayerCard = firstPlayerCards.get(0);
            int secondPlayerCard = secondPlayerCards.get(0);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);

                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);

            } else if (firstPlayerCard < secondPlayerCard) {
                secondPlayerCards.add(secondPlayerCard);
                secondPlayerCards.add(firstPlayerCard);

                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);

            } else {
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }
        }

        if (firstPlayerCards.isEmpty()) {
            System.out.printf("Second player wins! Sum: %d", sumPoints(secondPlayerCards));
        } else {
            System.out.printf("First player wins! Sum: %d", sumPoints(firstPlayerCards));
        }
    }

    public static int sumPoints(List<Integer> numbers) {

        int sum = 0;

        for (int num: numbers) {
            sum += num;
        }

        return sum;
    }
}
