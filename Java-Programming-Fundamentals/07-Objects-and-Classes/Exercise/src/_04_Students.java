import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _04_Students {

    public static class Student {

        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] studentInfo = scanner.nextLine().split(" ");

            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            double grade = Double.parseDouble(studentInfo[2]);

            Student student = new Student(firstName, lastName, grade);
            studentList.add(student);
        }

        ArrayList<Double> grades = getGrades(studentList);

        Collections.sort(grades);
        Collections.reverse(grades);

        printStudents(studentList, grades);
    }


    public static ArrayList<Double> getGrades(List<Student> studentList) {

        ArrayList<Double> grades = new ArrayList<>();

        for (Student student: studentList) {
            grades.add(student.getGrade());
        }

        return grades;
    }

    public static void printStudents(List<Student> studentList, List<Double> grades) {

        for (Double grade: grades) {
            for (Student student: studentList) {
                if (grade.equals(student.getGrade()))
                    System.out.printf("%s %s: %.2f%n",
                            student.getFirstName(),
                            student.getLastName(),
                            student.getGrade());
            }
        }
    }
}
