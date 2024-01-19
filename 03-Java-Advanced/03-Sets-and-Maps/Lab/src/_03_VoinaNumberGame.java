import java.util.*;
import java.util.stream.Collectors;

public class _03_VoinaNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerNumbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayerNumbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 1;

        while (rounds != 50) {

            int firstPlayerNum = firstPlayerNumbers.iterator().next();
            firstPlayerNumbers.remove(firstPlayerNum);

            int secondPlayerNum = secondPlayerNumbers.iterator().next();
            secondPlayerNumbers.remove(secondPlayerNum);

            if (firstPlayerNum > secondPlayerNum) {
                firstPlayerNumbers.add(firstPlayerNum);
                firstPlayerNumbers.add(secondPlayerNum);
            } else if (secondPlayerNum > firstPlayerNum){
                secondPlayerNumbers.add(firstPlayerNum);
                secondPlayerNumbers.add(secondPlayerNum);
            }

            rounds += 1;
        }

        if (firstPlayerNumbers.size() > secondPlayerNumbers.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerNumbers.size() < secondPlayerNumbers.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
