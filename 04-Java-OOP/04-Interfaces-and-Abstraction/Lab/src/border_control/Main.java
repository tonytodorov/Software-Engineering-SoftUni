package border_control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Citizen> citizenList = new ArrayList<>();
        List<Robot> robotList = new ArrayList<>();

        while (!"End".equals(command)) {
            String[] token = command.split("\\s+");

            String name = token[0];

            if (token.length == 3) {
                int age = Integer.parseInt(token[1]);
                String id = token[2];

                Citizen citizen = new Citizen(name, age, id);
                citizenList.add(citizen);
            } else {
                String model = token[1];

                Robot robot = new Robot(name, model);
                robotList.add(robot);
            }

            command = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();

        citizenList.stream()
                .map(Citizen::getId)
                .filter(citizen -> citizen.endsWith(fakeId))
                .forEach(System.out::println);

        robotList.stream()
                .map(Robot::getModel)
                .filter(robot -> robot.endsWith(fakeId))
                .forEach(System.out::println);
    }
}
