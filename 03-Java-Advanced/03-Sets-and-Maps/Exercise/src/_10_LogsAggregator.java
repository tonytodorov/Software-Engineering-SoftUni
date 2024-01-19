import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _10_LogsAggregator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> logs = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String ipAddress = tokens[0];
            String name = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if (!logs.containsKey(name)) {
                logs.put(name, new TreeMap<>());
            }

            if (logs.get(name).containsKey(ipAddress)) {
                logs.get(name).put(ipAddress, logs.get(name).get(ipAddress) + duration);
            } else {
                logs.get(name).put(ipAddress, duration);
            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry: logs.entrySet()) {

            Map<String, Integer> innerMap = entry.getValue();
            int totalDuration = 0;

            for (Map.Entry<String, Integer> inner: innerMap.entrySet()) {
                totalDuration += inner.getValue();
            }

            System.out.printf("%s: %d [", entry.getKey(), totalDuration);
            int size = innerMap.size() - 1;

            for (Map.Entry<String, Integer> inner: innerMap.entrySet()) {
                System.out.print(inner.getKey());

                if (size == 0) {
                    System.out.println("]");
                } else {
                    System.out.print(", ");
                }

                size -= 1;
            }
        }
    }
}
