import java.util.*;

public class _01_ClimbThePeaks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> portionsStack = new ArrayDeque<>();
        Deque<Integer> staminaQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(portionsStack::push);

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(staminaQueue::offer);

        Map<Integer, String> peaks = new LinkedHashMap<>();
        peaks.put(80, "Vihren");
        peaks.put(90, "Kutelo");
        peaks.put(100, "Banski Suhodol");
        peaks.put(60, "Polezhan");
        peaks.put(70, "Kamenitza");

        List<String> peaksClimbed = new ArrayList<>();

        int countPeaks = 0;

        while (!portionsStack.isEmpty() && !staminaQueue.isEmpty() && countPeaks != 5) {
            int queue = staminaQueue.poll();
            int stack = portionsStack.pop();

            int sum = queue + stack;

            Optional<Map.Entry<Integer, String>> firstKey = peaks.entrySet().stream().findFirst();

            if (sum >= firstKey.get().getKey()) {
                countPeaks++;
                peaksClimbed.add(firstKey.get().getValue());
                peaks.remove(firstKey.get().getKey());
            }
        }

        if (countPeaks == 5) {
            System.out.printf("Alex did it! He climbed all top " +
                    "five Pirin peaks in one week -> @FIVEinAWEEK%n" +
                    "Conquered peaks: %n");
            peaksClimbed.forEach(System.out::println);
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            if (!peaksClimbed.isEmpty()) {
                System.out.println("Conquered peaks:");
                peaksClimbed.forEach(System.out::println);
            }
        }
    }
}
