import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_ChickenSnack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> moneyStack = new ArrayDeque<>();
        Deque<Integer> priceQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(moneyStack::push);

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(priceQueue::offer);

        int countFood = 0;

        while (!moneyStack.isEmpty() && !priceQueue.isEmpty()) {
            int price = priceQueue.poll();
            int money = moneyStack.pop();

            if (price == money) {
                countFood += 1;
            } else if (money > price) {
                countFood += 1;
                int diff = money - price;

                if (moneyStack.size() >= 1) {
                    moneyStack.push(moneyStack.pop() + diff);
                }
            }
        }

        if (countFood == 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else if (countFood == 1) {
            System.out.printf("Henry ate: %d food.", countFood);
        } else if (countFood < 4) {
            System.out.printf("Henry ate: %d foods.", countFood);
        } else {
            System.out.printf("Gluttony of the day! Henry ate %d foods.", countFood);
        }
    }
}
