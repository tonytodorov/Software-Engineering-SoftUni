package football_team_generator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Team> teamMap = new LinkedHashMap<>();

        while (!"END".equals(command)) {
            String[] token = command.split(";");
            String operation = token[0];

            if ("Team".equals(operation)) {
                addTeam(command, teamMap);
            } else if ("Add".equals(operation)) {
                addPlayer(command, teamMap);
            } else if ("Remove".equals(operation)) {
                removePlayer(command, teamMap);
            } else {
                getRating(command, teamMap);
            }

            command = scanner.nextLine();
        }
    }

    private static void addTeam(String command, Map<String, Team> teamMap) {

        try {
            String[] token = command.split(";");
            String team = token[1];
            teamMap.putIfAbsent(team, new Team(team));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addPlayer(String command, Map<String, Team> teamMap) {

        try {
            String[] token = command.split(";");
            String currentTeam = token[1];
            Team team = teamMap.get(currentTeam);

            if (teamMap.containsKey(currentTeam)) {
                String name = token[2];
                int endurance = Integer.parseInt(token[3]);
                int sprint = Integer.parseInt(token[4]);
                int dribble = Integer.parseInt(token[5]);
                int passing = Integer.parseInt(token[6]);
                int shooting = Integer.parseInt(token[7]);
                Player player = new Player(name, endurance, sprint, dribble, passing, shooting);
                team.addPlayer(player);
            } else {
                System.out.printf("Team %s does not exist.%n", currentTeam);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removePlayer(String command, Map<String, Team> teamMap) {
        try {
            String[] token = command.split(";");
            String teamName = token[1];
            Team team = teamMap.get(teamName);

            if (teamMap.containsKey(teamName)) {
                String name = token[2];
                team.removePlayer(name);
            } else {
                System.out.printf("Team %s does not exist.", teamName);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getRating(String command, Map<String, Team> teamMap) {
        String[] token = command.split(";");
        String currentTeam = token[1];
        Team team = teamMap.get(currentTeam);

        if (teamMap.containsKey(currentTeam)) {
            System.out.printf("%s - %.0f%n", currentTeam, team.getRating());
        } else {
            System.out.printf("Team %s does not exist.%n", currentTeam);
        }
    }
}