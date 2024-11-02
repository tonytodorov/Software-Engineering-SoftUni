package org.hibernate;

import org.hibernate.entities.Address;
import org.hibernate.entities.Employee;
import org.hibernate.entities.Project;
import org.hibernate.entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

//        _02_ChangeCasing(em);
//        _03_ContainsEmployee(em);
//        _04_EmployeesWithSalaryAbove50000(em);
//        _05_EmployeesFromDepartment(em);
//        _06_AddingNewAddressAndUpdatingEmployee(em);
//        _07_AddressesWithEmployeeCount(em);
//        _08_GetEmployeesWithProject(em);
//        _09_FindTheLatest10Projects(em);
//        _10_IncreaseSalaries(em);
//        _11_FindEmployeesByFirstName(em);
        _12_EmployeesMaximumSalaries(em);
        em.getTransaction().commit();
        em.close();
    }

    private static void _12_EmployeesMaximumSalaries(EntityManager em) {
        List<Employee> resultList = em
                .createQuery("SELECT d.name, MAX(e.salary) FROM Department d " +
                        "JOIN d.employees" +
                        "GROUP BY d.name", Employee.class)
                .getResultList();

        resultList.forEach(d -> System.out.printf("%s %.2f",
                d.getDepartment().getName(),
                d.getSalary()));
    }

    private static void _11_FindEmployeesByFirstName(EntityManager em) throws IOException {
        String pattern = READER.readLine();
        pattern += "%";

        List<Employee> employees = em
                .createQuery("FROM Employee WHERE firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList();

        employees.forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary()));
    }

    private static void _10_IncreaseSalaries(EntityManager em) {
        List<Employee> employees = em
                .createQuery("FROM Employee WHERE department.name " +
                        "IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList();

        employees.forEach(e -> {
            e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12)));
            em.persist(e);
            System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary());
        });
    }

    private static void _09_FindTheLatest10Projects(EntityManager em) {
        List<Project> resultList = em
                .createQuery("FROM Project ORDER BY startDate DESC, name", Project.class)
                .setMaxResults(10)
                .getResultList();

        resultList.forEach(p -> System.out.printf("Project name: %s%n" +
                        " \tProject Description: %s%n" +
                        " \tProject Start Date: %s%n" +
                        " \tProject End Date: %s%n",
                p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate()));
    }

    private static void _08_GetEmployeesWithProject(EntityManager em) throws IOException {
        Integer employeeId = Integer.parseInt(READER.readLine());

        Employee employee = em.createQuery("FROM Employee WHERE id = :id", Employee.class)
                .setParameter("id", employeeId)
                .getSingleResult();

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        employee.getProjects().forEach(project -> System.out.println(project.getName()));
    }

    private static void _07_AddressesWithEmployeeCount(EntityManager em) {
        List<Address> resultList = em
                .createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        resultList.forEach(address -> System.out.printf("%s %s - %d employees%n",
                address.getText(),
                address.getTown().getName(),
                address.getEmployees().size()));
    }

    private static void _06_AddingNewAddressAndUpdatingEmployee(EntityManager em) throws IOException {
        String lastName = READER.readLine();

        Address address = new Address();
        address.setText("Vitoshka 15");
        em.persist(address);

        Employee employee = em
                .createQuery("FROM Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getSingleResult();

        employee.setAddress(address);
        em.persist(employee);


    }

    private static void _05_EmployeesFromDepartment(EntityManager em) {
        List<Employee> resultList = em
                .createQuery("FROM Employee WHERE department.name = 'Research and Development' " +
                        "ORDER BY salary, id", Employee.class)
                .getResultList();

        resultList.forEach(employee -> System.out.printf("%s %s from Research and Development - $%s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary()));
    }

    private static void _04_EmployeesWithSalaryAbove50000(EntityManager em) {
        List<Employee> resultList = em
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList();

        resultList.forEach(employee -> System.out.println(employee.getFirstName()));
    }

    private static void _03_ContainsEmployee(EntityManager em) throws IOException {
        String[] strings = READER.readLine().split("\\s+");

        List<Employee> resultList = em
                .createQuery("FROM Employee WHERE firstName = :firstName AND lastName = :lastName", Employee.class)
                .setParameter("firstName", strings[0])
                .setParameter("lastName", strings[1])
                .getResultList();

        System.out.printf(resultList.isEmpty() ? "No" : "Yes");
    }

    private static void _02_ChangeCasing(EntityManager em) {
        List<Town> towns = em
                .createQuery("FROM Town WHERE LENGTH(name) > 5", Town.class).getResultList();

        towns.forEach(town -> {
            town.setName(town.getName().toUpperCase());
            em.persist(town);
        });

        em.createQuery("UPDATE Town SET name = UPPER(name) WHERE LENGTH(name) > 5").executeUpdate();
    }
}