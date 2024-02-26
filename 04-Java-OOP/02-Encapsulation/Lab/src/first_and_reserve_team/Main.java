package first_and_reserve_team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Team team = new Team("Black Eagles");

        List<Person> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] player = scanner.nextLine().split("\\s+");

            Person person = new Person(player[0], player[1],
                    Integer.parseInt(player[2]), Double.parseDouble(player[3]));
            players.add(person);
        }

        for (Person player: players) {
            team.addPlayer(player);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reverse team have " + team.getReserveTeam().size() + " players");
    }
}
