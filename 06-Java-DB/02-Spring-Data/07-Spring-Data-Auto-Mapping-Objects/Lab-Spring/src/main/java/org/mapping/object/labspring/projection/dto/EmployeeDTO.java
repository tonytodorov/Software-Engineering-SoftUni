package org.mapping.object.labspring.projection.dto;

import org.mapping.object.labspring.projection.entities.Employee;

public class EmployeeDTO {

    private long id;
    private String firstName;
    private String lastName;
    private double salary;
    private Employee manager;

    public EmployeeDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f - Manager: %s",
                firstName,
                lastName,
                salary,
                manager == null ? "[no manager]" : manager.getFirstName());
    }
}
