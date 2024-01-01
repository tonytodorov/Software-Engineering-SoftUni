import java.util.*;

public class _08_UserLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("=|\\s+");

            String username = tokens[5];
            String ipAddress = tokens[1];

            if (!users.containsKey(username)) {
                users.put(username, new LinkedHashMap<>());
            }

            if (users.get(username).containsKey(ipAddress)) {
                users.get(username).put(ipAddress, users.get(username).get(ipAddress) + 1);
            } else {
                users.get(username).put(ipAddress, 1);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry: users.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());

            Map<String, Integer> innerMap = entry.getValue();

            int size = users.get(entry.getKey()).size() - 1;

            for (Map.Entry<String, Integer> inner: innerMap.entrySet()) {
                System.out.printf("%s => %d", String.join(", ", inner.getKey()), inner.getValue());

                if (size == 0) {
                    System.out.println(".");
                } else {
                    System.out.print(", ");
                }

                size -= 1;
            }
        }
    }
}