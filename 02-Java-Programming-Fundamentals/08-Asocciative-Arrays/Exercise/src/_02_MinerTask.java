import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02_MinerTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!command.equals("stop")) {

            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(command)) {
                resources.put(command, 0);
            }

            resources.put(command, resources.get(command) + quantity);

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry: resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
