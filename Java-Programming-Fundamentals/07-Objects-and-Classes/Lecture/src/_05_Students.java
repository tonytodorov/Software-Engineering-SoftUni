import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05_Students {

    public static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getAge() {
            return this.age;
        }

        public String getHometown() {
            return this.hometown;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Student> students = new ArrayList<>();

        while (!command.equals("end")) {

            String[] tokens = command.split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String hometown = tokens[3];

            Student student = new Student(firstName, lastName, age, hometown);

            students.add(student);
            command = scanner.nextLine();
        }

        String city = scanner.nextLine();

        for (Student stud: students) {
            if (city.equals(stud.getHometown())) {
                System.out.printf("%s %s is %d years old%n",
                        stud.getFirstName(), stud.getLastName(), stud.getAge());
            }
        }
    }
}
