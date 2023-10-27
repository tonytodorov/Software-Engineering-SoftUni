package studentV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Student> studentList = new ArrayList<>();

        while (!command.equals("end")) {

            String[] tokens = command.split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String hometown = tokens[3];

            if (isStudentExisting(studentList, firstName, lastName)) {
                Student student = getStudent(studentList, firstName, lastName);
                student.setAge(age);
                student.setHometown(hometown);
            } else {
                Student student = new Student(firstName, lastName, age, hometown);
                studentList.add(student);
            }

            command = scanner.nextLine();
        }

        String city = scanner.nextLine();

        for (Student student: studentList) {
            if (student.getHometown().equals(city)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(),
                        student.getLastName(), student.getAge());
            }
        }
    }

    public static boolean isStudentExisting(List<Student> studentList, String firstName, String lastName) {

        for (Student student: studentList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }

        return false;
    }

    public static Student getStudent(List<Student> studentList, String firstName, String lastName) {
        
        Student existingStudent = null;

        for (Student student: studentList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
                break;
            }
        }

        return existingStudent;
    }
}
