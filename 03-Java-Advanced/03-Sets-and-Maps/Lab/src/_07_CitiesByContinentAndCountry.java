import java.util.*;

public class _07_CitiesByContinentAndCountry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> cities = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!cities.containsKey(continent)) {
                cities.put(continent, new LinkedHashMap<>());
            }

            if (!cities.get(continent).containsKey(country)) {
                cities.get(continent).put(country, new ArrayList<>());
            }

            cities.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, Map<String, List<String>>> entry: cities.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());

            Map<String, List<String>> innerMap = entry.getValue();

            for (Map.Entry<String, List<String>> country: innerMap.entrySet()) {
                System.out.printf("%s -> %s%n", country.getKey(), String.join(", ", country.getValue()));
            }
        }
    }
}
