import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_MonsterExtermination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> armorQueue = new ArrayDeque<>();
        Deque<Integer> strikeStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(","))
                .map(Integer::parseInt)
                .forEach(armorQueue::offer);

        Arrays.stream(scanner.nextLine()
                .split(","))
                .map(Integer::parseInt)
                .forEach(strikeStack::push);

        int monsterKilled = 0;

        while (!armorQueue.isEmpty() && !strikeStack.isEmpty()) {
            int armor = armorQueue.poll();
            int strike = strikeStack.pop();

            if (strike >= armor) {
                monsterKilled++;
                strike -= armor;

                if (strikeStack.size() > 0) {
                    strikeStack.push(strikeStack.pop() + strike);
                } else {
                    if (strike > 0) {
                        strikeStack.push(strike);
                    }
                }
            } else {
                armor -= strike;
                armorQueue.offer(armor);
            }
        }

        if (armorQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }

        if (strikeStack.isEmpty()){
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", monsterKilled);
    }
}
