import java.util.Scanner;

public class _01_SoftUniReception {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());

        int studentCount = Integer.parseInt(scanner.nextLine());

        int totalHelp = firstEmployee + secondEmployee + thirdEmployee;
        int hours = 0;

        while (studentCount > 0) {
            studentCount -= totalHelp;
            hours += 1;

            if (hours % 4 == 0) {
                hours += 1;
            }
        }

        System.out.printf("Time needed: %dh.", hours);
    }
}
