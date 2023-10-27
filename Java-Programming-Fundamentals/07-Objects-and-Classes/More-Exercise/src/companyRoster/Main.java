package companyRoster;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split(" ");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = new Employee(name, salary, position, department);

            setEmail(tokens, employee);
            setAge(tokens, employee);

            employeeList.add(employee);
        }

        String highestAvgSalaryDep = getHighestAvgSalary(employeeList);

        List<Employee> result = new ArrayList<>();

        for (Employee employee: employeeList) {
            if (employee.getDepartment().equals(highestAvgSalaryDep)) {
                result.add(employee);
            }
        }

        result.sort(Comparator.comparing(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", highestAvgSalaryDep);

        for (Employee emp: result) {
            System.out.printf("%s %.2f %s %d%n",
                    emp.getName(),
                    emp.getSalary(),
                    emp.getEmail(),
                    emp.getAge());
        }
    }


    public static void setEmail(String[] tokens, Employee employee) {

        if (tokens.length - 1 >= 4) {
            String email = tokens[4];
            employee.setEmail(email);
        } else {
            employee.setEmail("n/a");
        }
    }

    public static void setAge(String[] tokens, Employee employee) {

        if (tokens.length - 1 >= 5) {
            int age = Integer.parseInt(tokens[5]);
            employee.setAge(age);
        } else {
            employee.setAge(-1);
        }
    }


    public static String getHighestAvgSalary(List<Employee> employeeList) {

        double maxValue = Double.MIN_VALUE;
        String currentDepartment = "";

        for (Employee employees: employeeList) {
            double totalSalary = 0.00;
            int countPeople = 0;

            String department = employees.getDepartment();

            for (Employee emp: employeeList) {
                if (department.equals(emp.getDepartment())) {
                    double salary = emp.getSalary();
                    totalSalary += salary;
                    countPeople += 1;
                }
            }

            double result = totalSalary / countPeople;

            if (result > maxValue) {
                maxValue = result;
                currentDepartment = department;
            }

        }

        return currentDepartment;
    }
}
