package org.mapping.object.advancedMapping.dto;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerDTO {

    private String firstName;
    private String lastName;
    private List<EmployeeDTO> staff;

    public ManagerDTO() {}

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

    public List<EmployeeDTO> getStaff() {
        return staff;
    }

    public void setStaff(List<EmployeeDTO> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        String formattedStaff = staff.stream()
                .map(EmployeeDTO::toString)
                .collect(Collectors.joining("\n"));

        return String.format("%s %s | Employees: %d%n%s",
                firstName, lastName, staff.size(), formattedStaff
        );
    }
}
