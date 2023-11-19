import java.util.Scanner;

public class _02_SpaceTravel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String route = scanner.nextLine();
        int startFuel = Integer.parseInt(scanner.nextLine());
        int startAmmunition = Integer.parseInt(scanner.nextLine());

        String[] command = route.split("\\|\\|");

        for (int i = 0; i < command.length; i++) {

            String currentCommand = command[i];
            String[] tokens = currentCommand.split(" ");

            String operation = tokens[0];

            if (operation.equals("Travel")) {
                int lightYear = Integer.parseInt(tokens[1]);

                if (startFuel >= lightYear) {
                    startFuel -= lightYear;
                    System.out.printf("The spaceship travelled %d light-years.%n", lightYear);
                } else {
                    System.out.println("Mission failed.");
                    return;
                }
            } else if (operation.equals("Enemy")) {
                int enemyArmour = Integer.parseInt(tokens[1]);

                if (startAmmunition >= enemyArmour) {
                    startAmmunition -= enemyArmour;
                    System.out.printf("An enemy with %d armour is defeated.%n", enemyArmour);
                } else {
                    int consumedFuel = enemyArmour * 2;
                    if (consumedFuel > startFuel) {
                        System.out.println("Mission failed.");
                        return;
                    } else {
                        startFuel -= consumedFuel;
                        System.out.printf("An enemy with %d armour is outmaneuvered.%n", enemyArmour);
                    }
                }
            } else if (operation.equals("Repair")) {
                int repair = Integer.parseInt(tokens[1]);
                int addedAmmunition = repair * 2;

                startFuel += repair;
                startAmmunition += addedAmmunition;

                System.out.printf("Ammunitions added: %d.%n", addedAmmunition);
                System.out.printf("Fuel added: %d.%n", repair);
            } else if (operation.equals("Titan")) {
                System.out.println("You have reached Titan, all passengers are safe.");
                return;
            }
        }
    }
}
