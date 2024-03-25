package softUni;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        if (this.data.size() > this.capacity) {
            return "The hall is full";
        } else if (data.contains(student)) {
            return "Student is already in the hall.";
        } else {
            this.data.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }
    }

    public String remove(Student student) {
        boolean isRemoved = this.data.remove(student);

        if (isRemoved) {
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return this.data.stream()
                .filter(fn -> fn.getFirstName().equals(firstName))
                .filter(ln -> ln.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);

    }

    public String getStatistics() {
        return String.format("Hall size: %s%n%s",
                this.data.size(),
                this.data.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
