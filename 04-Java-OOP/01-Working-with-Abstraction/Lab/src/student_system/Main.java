package student_system;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String[] input = scanner.nextLine().split("\\s+");

        while (!"Exit".equals(input[0])) {
            studentSystem.command(input);
            input = scanner.nextLine().split("\\s+");
        }
    }
}
