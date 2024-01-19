import java.util.*;

public class _08_CompanyUsers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<String>> companyUsers = new LinkedHashMap<>();

        while (!command.equals("End")) {

            String[] data = command.split(" -> ");

            String companyName = data[0];
            String employeeId = data[1];

            if (!companyUsers.containsKey(companyName)) {
                companyUsers.put(companyName, new ArrayList<>());
            }

            if (!companyUsers.get(companyName).contains(employeeId)) {
                companyUsers.get(companyName).add(employeeId);
            }
            
            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry: companyUsers.entrySet()) {
            System.out.println(entry.getKey());

            for (String employeeId: entry.getValue()) {
                System.out.printf("-- %s%n", employeeId);
            }
        }

    }
}
