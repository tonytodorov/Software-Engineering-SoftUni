import java.util.Scanner;

public class _02_MuOnline {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;

        String command = scanner.nextLine();
        String[] text = command.split("\\|");

        int countRooms = 0;
        int difference;
        int bestRoom;

        boolean isMonsterWin = false;

        for (String str : text) {

            countRooms += 1;

            String[] num = str.split(" ");
            String operation = num[0];
            int numbers = Integer.parseInt(num[1]);

            if (operation.equals("potion")) {

                if (health + numbers > 100) {
                    difference = 100 - health;
                    health = 100;
                    System.out.printf("You healed for %d hp.%n", difference);
                } else {
                    health += numbers;
                    System.out.printf("You healed for %d hp.%n", numbers);
                }

                System.out.printf("Current health: %d hp.%n", health);

            } else if (operation.equals("chest")) {
                bitcoins += numbers;
                System.out.printf("You found %d bitcoins.%n", numbers);
            } else {
                health -= numbers;

                if (health > 0) {
                    System.out.printf("You slayed %s.%n", operation);
                } else {
                    isMonsterWin = true;
                    System.out.printf("You died! Killed by %s.%n", operation);
                    bestRoom = countRooms;
                    System.out.printf("Best room: %d", bestRoom);
                    break;
                }
            }
        }

        if (!isMonsterWin) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", health);
        }
    }
}
