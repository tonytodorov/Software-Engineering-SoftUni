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

        int health = Integer.parseInt(scanner.nextLine());
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
                }

            }



            command = scanner.nextLine();
        }
    }


    public static void addElements(String[] array, List<Integer> list) {

        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
    }

    public static boolean isIndexValid(List<Integer> list, int index) {
        return index >= 0 && index <= list.size();
    }
}
