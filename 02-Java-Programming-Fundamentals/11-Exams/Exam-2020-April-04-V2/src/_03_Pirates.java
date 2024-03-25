import java.util.*;

public class _03_Pirates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<Integer>> cities = new LinkedHashMap<>();

        while (!command.equals("Sail")) {

            String[] tokens = command.split("[\\|\\|]+");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (!cities.containsKey(city)) {
                cities.put(city, new ArrayList<>());
                cities.get(city).add(population);
                cities.get(city).add(gold);
            } else {
                cities.get(city).set(0, cities.get(city).get(0) + population);
                cities.get(city).set(1, cities.get(city).get(1) + gold);
            }

            command = scanner.nextLine();
        }

        String events = scanner.nextLine();

        while (!events.equals("End")) {

            String[] tokens = events.split("=>");
            String operation = tokens[0];

            if (operation.equals("Plunder")) {
                plunder(tokens, cities);
            } else {
                prosper(tokens, cities);
            }

            events = scanner.nextLine();
        }

        print(cities);
    }

    public static void plunder(String[] tokens, Map<String, List<Integer>> cities) {

        String town = tokens[1];
        int people = Integer.parseInt(tokens[2]);
        int gold = Integer.parseInt(tokens[3]);

        cities.get(town).set(0, cities.get(town).get(0) - people);
        cities.get(town).set(1, cities.get(town).get(1) - gold);

        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

        if (cities.get(town).get(0) <= 0 || cities.get(town).get(1) <= 0) {
            cities.remove(town);
            System.out.printf("%s has been wiped off the map!%n", town);
        }
    }

    public static void prosper(String[] tokens, Map<String, List<Integer>> cities) {

        String town = tokens[1];
        int gold = Integer.parseInt(tokens[2]);

        if (gold >= 0) {
            cities.get(town).set(1, cities.get(town).get(1) + gold);
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                    gold, town, cities.get(town).get(1));
        } else {
            System.out.println("Gold added cannot be a negative number!");
        }
    }

    public static void print(Map<String, List<Integer>> cities) {

        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",
                    cities.size());

            for (Map.Entry<String, List<Integer>> entry: cities.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }
        }
    }
}
