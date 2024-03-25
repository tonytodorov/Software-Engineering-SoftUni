import java.util.*;

public class _03_Followers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> followers = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Log out")) {

            String[] tokens = command.split(": ");
            String operation = tokens[0];

            if (operation.equals("New follower")) {
                String username = tokens[1];

                if (!followers.containsKey(username)) {
                    followers.put(username, new ArrayList<>());
                    followers.get(username).add(0);
                    followers.get(username).add(0);
                }
            } else if (operation.equals("Like")) {
                String username = tokens[1];
                int count = Integer.parseInt(tokens[2]);

                if (followers.containsKey(username)) {
                    followers.get(username).set(0, followers.get(username).get(0) + count);
                } else {
                    followers.put(username, new ArrayList<>());
                    followers.get(username).add(count);
                    followers.get(username).add(0);
                }
            } else if (operation.equals("Comment")) {
                String username = tokens[1];
                if (followers.containsKey(username)) {
                    followers.get(username).set(1, followers.get(username).get(1) + 1);
                } else {
                    followers.put(username, new ArrayList<>());
                    followers.get(username).add(0);
                    followers.get(username).add(1);
                }
            } else if (operation.equals("Blocked")) {
                String username = tokens[1];

                if (!followers.containsKey(username)) {
                    System.out.printf("%s doesn't exist.%n", username);
                } else {
                    followers.remove(username);
                }
            }

            command = scanner.nextLine();
        }

        System.out.printf("%d followers%n", followers.size());

        for (Map.Entry<String, List<Integer>> entry: followers.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().get(0) + entry.getValue().get(1));
        }
    }
}
