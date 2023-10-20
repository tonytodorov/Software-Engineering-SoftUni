import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_ManOWar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstShip = scanner.nextLine().split(">");
        List<Integer> pirateShip = new ArrayList<>();

        addElements(firstShip, pirateShip);

        String[] secondShip =scanner.nextLine().split(">");
        List<Integer> warship = new ArrayList<>();

        addElements(secondShip, warship);

        int maxHealth = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Retire")) {

            String[] tokens = command.split(" ");
            String operation = tokens[0];

            if (operation.equals("Fire")) {
                int index = Integer.parseInt(tokens[1]);
                int damage = Integer.parseInt(tokens[2]);

                boolean isIndexValid = isIndexValid(warship, index);

                if (isIndexValid) {
                    warship.set(index, warship.get(index) - damage);

                    boolean isSectionBreak = isSectionBreak(warship);

                    if (isSectionBreak) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                }
            } else if (operation.equals("Defend")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                int damage = Integer.parseInt(tokens[3]);

                boolean isStarIndexValid = isIndexValid(pirateShip, startIndex);
                boolean isEndIndexValid = isIndexValid(pirateShip, endIndex);

                if (isStarIndexValid && isEndIndexValid) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        pirateShip.set(i, pirateShip.get(i) - damage);
                    }

                    boolean isSectionBreak = isSectionBreak(pirateShip);

                    if (isSectionBreak) {
                        System.out.println("You lost! The pirate ship has sunken.");
                        return;
                    }
                }
            } else if (operation.equals("Repair")) {
                int index = Integer.parseInt(tokens[1]);
                int health = Integer.parseInt(tokens[2]);

                boolean isIndexValid = isIndexValid(pirateShip, index);

                if (isIndexValid) {
                    pirateShip.set(index, pirateShip.get(index) + health);

                    if (pirateShip.get(index) > maxHealth) {
                       pirateShip.set(index, maxHealth);
                    }
                }
            } else if (operation.equals("Status")) {
                double bound = maxHealth * 0.2;

                int count = 0;

                for (int i = 0; i < pirateShip.size(); i++) {
                    if (pirateShip.get(i) < bound) {
                        count += 1;
                    }
                }

                System.out.printf("%d sections need repair.%n", count);
            }

            command = scanner.nextLine();
        }

        System.out.printf("Pirate ship status: %d%n", sumSectionShip(pirateShip));
        System.out.printf("Warship status: %d", sumSectionShip(warship));
    }


    public static void addElements(String[] array, List<Integer> list) {

        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
    }

    public static boolean isIndexValid(List<Integer> list, int index) {
        return index >= 0 && index <= list.size();
    }

    public static boolean isSectionBreak(List<Integer> list) {

        for (Integer integer : list) {
            if (integer <= 0) {
                return true;
            }
        }

        return false;
    }

    public static int sumSectionShip(List<Integer> list) {

        int sum = 0;

        for (Integer element : list) {
            sum += element;
        }

        return sum;
    }
}
