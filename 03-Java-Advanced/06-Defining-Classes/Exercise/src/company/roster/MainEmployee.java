package company.roster;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class MainEmployee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            Employee employee;

            if (data.length == 6) {
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (data.length == 5) {
                String text = data[4];
                if (text.matches("\\d+")) {
                    int age = Integer.parseInt(data[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    employee = new Employee(name, salary, position, department, text);
                }
            } else {
                employee = new Employee(name, salary, position, department);
            }

            employees.add(employee);
        }

        Map<String, List<Employee>> departmentMap = employees
                .stream()
                .collect(groupingBy(Employee::getDepartment));


        Map.Entry<String, List<Employee>> highestSalary = departmentMap
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    double avgSalary1 = e1.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    double avgSalary2 = e2.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    return Double.compare(avgSalary2, avgSalary1);

                })
                .findFirst()
                .orElse(null);


        System.out.printf("Highest Average Salary: %s%n", highestSalary.getKey());

        highestSalary
                .getValue()
                .stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
