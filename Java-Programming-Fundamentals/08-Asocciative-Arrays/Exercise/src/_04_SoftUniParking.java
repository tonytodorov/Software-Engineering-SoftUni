import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_SoftUniParking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> parkingValidation = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] command = scanner.nextLine().split(" ");
            String operation = command[0];
            String username = command[1];

            if (operation.equals("register")) {
                String number = command[2];

                if (!parkingValidation.containsKey(username)) {
                    parkingValidation.put(username, number);
                    System.out.printf("%s registered %s successfully%n", username, number);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", number);
                }
            }

            if (operation.equals("unregister")) {
                if (!parkingValidation.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    parkingValidation.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }
            }
        }

        for (Map.Entry<String, String> entry: parkingValidation.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
