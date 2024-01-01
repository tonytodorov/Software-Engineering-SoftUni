import java.util.*;
import java.util.stream.Collectors;

public class _09_PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> countries = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new TreeMap<>());
            }

            countries.get(country).put(city, population);


            input = scanner.nextLine();
        }

    }
}
