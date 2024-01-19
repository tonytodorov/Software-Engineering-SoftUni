import java.util.Scanner;

public class _01_CounterStrike {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        int battleCount = 0;
        boolean isEnergyFinish = false;

        while (!command.equals("End of battle")) {

            int distance = Integer.parseInt(command);

            if (energy < distance) {
                isEnergyFinish = true;
                break;
            }

            energy -= distance;
            battleCount += 1;

            if (battleCount % 3 == 0) {
                energy += battleCount;
            }

            command = scanner.nextLine();
        }

        if (isEnergyFinish) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",
                    battleCount, energy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d", battleCount, energy);
        }
    }
}
