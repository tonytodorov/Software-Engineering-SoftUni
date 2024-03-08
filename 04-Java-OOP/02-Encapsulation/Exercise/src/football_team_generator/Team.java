package football_team_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (null == name || name.isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty");
        }

        this.name = name;
    }

    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public void removePlayer(String name) {
        Player currentPlayer = this.players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (null != currentPlayer) {
            players.remove(currentPlayer);
        } else {
            System.out.printf("Player %s is not in %s team.%n", name, getName());
        }
    }

    public double getRating() {
        List<Double> collect = this.players.stream()
                .map(Player::overallSkillLevel)
                .collect(Collectors.toList());

        // TODO

        return 0;
    }
}
