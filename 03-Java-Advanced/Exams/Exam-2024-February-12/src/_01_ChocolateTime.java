import java.util.*;

public class _01_ChocolateTime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQueue = new ArrayDeque<>();
        Deque<Double> cocoaStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Double::parseDouble)
                .forEach(milkQueue::offer);

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cocoaStack::push);

        Map<String, Double> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 30.00);
        chocolates.put("Dark Chocolate", 50.00);
        chocolates.put("Baking Chocolate", 100.00);

        Map<String, Integer> madeChocolates = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cocoaStack.isEmpty()) {
            double queue = milkQueue.poll();
            double stack = cocoaStack.pop();

            double result = (stack / (queue + stack)) * 100;

            boolean isChocolateMade = false;

            for (Map.Entry<String, Double> entry : chocolates.entrySet()) {
                if (entry.getValue() == result) {
                    madeChocolates.putIfAbsent(entry.getKey(), 0);
                    madeChocolates.put(entry.getKey(), madeChocolates.get(entry.getKey()) + 1);
                    isChocolateMade = true;
                    break;
                }
            }

            if (!isChocolateMade) {
                queue += 10;
                milkQueue.offer(queue);
            }
        }

        if (madeChocolates.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        if (!madeChocolates.isEmpty()) {
            printMap(madeChocolates);
        }
    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
