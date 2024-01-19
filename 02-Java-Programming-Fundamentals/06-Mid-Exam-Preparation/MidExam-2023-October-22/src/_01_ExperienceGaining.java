import java.util.Scanner;

public class _01_ExperienceGaining {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededExperience = Double.parseDouble(scanner.nextLine());
        int countBattles = Integer.parseInt(scanner.nextLine());

        double totalExperience = 0.00;
        int currentBattle = 0;

        boolean isExperienceReached = false;

        for (int i = 1; i <= countBattles; i++) {
            double experience = Double.parseDouble(scanner.nextLine());

            if (i % 15 == 0) {
                experience *= 1.05;
            } else if (i % 5 == 0) {
                experience *= 0.9;
            } else if (i % 3 == 0) {
                experience *= 1.15;
            }

            totalExperience += experience;

            if (totalExperience >= neededExperience) {
                isExperienceReached = true;
                currentBattle = i;
                break;
            }

        }

        if (isExperienceReached) {
            System.out.printf("Player successfully collected his needed experience for %d battles.",
                    currentBattle);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.",
                    neededExperience - totalExperience);
        }
    }
}
