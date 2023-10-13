import java.util.Scanner;

public class _01_BonusScoringSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = Double.MIN_VALUE;
        int maxAttendance = 0;

        for (int i = 0; i < students; i++) {

            int studentAttendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = Math.round((1.0 * studentAttendance / lectures) * (5 + bonus));

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxAttendance = studentAttendance;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttendance);
    }
}
