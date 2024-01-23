package company.roster;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainEmployee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Employee> employees = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            Employee employee = new Employee(data[0], Double.parseDouble(data[1]), data[2],
                    data[3], data[4], Integer.parseInt(data[5]));

            employees.putIfAbsent(employee.getDepartment(), employee);
        }

        System.out.println();
    }
}
