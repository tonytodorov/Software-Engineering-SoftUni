package student_system;

public class Student {

    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s is %s years old.", name, age) + checkGrade();
    }

    private String checkGrade() {
        if (grade >= 5.00) {
            return " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            return " Average student.";
        } else {
            return " Very nice person.";
        }
    }
}
