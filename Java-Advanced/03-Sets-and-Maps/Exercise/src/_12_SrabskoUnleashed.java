import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _12_SrabskoUnleashed {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<singerName>[A-Za-z]+\\s?[A-Za-z]*)\\s+@" +
                "(?<cityName>[A-Za-z]+\\s?[A-Za-z]*)\\s+" +
                "(?<ticketsQuantity>\\d+)\\s+(?<ticketPrice>\\d+)");

        Map<String, Map<String, Integer>> cities = new LinkedHashMap<>();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singerName = matcher.group("singerName");
                String cityName = matcher.group("cityName");
                int ticketQuantity = Integer.parseInt(matcher.group("ticketsQuantity"));
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));

                if (!cities.containsKey(cityName)) {
                    cities.put(cityName, new LinkedHashMap<>());
                }

                if (!cities.get(cityName).containsKey(singerName)) {
                    cities.get(cityName).put(singerName, ticketQuantity * ticketPrice);
                } else {
                    cities.get(cityName).put(singerName, cities.get(cityName).get(singerName) + (ticketQuantity * ticketPrice));
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry: cities.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);

            Map<String, Integer> innerMap = entry.getValue();

            LinkedHashMap<String, Integer> sortedMap = innerMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            for (Map.Entry<String, Integer> inner: sortedMap.entrySet()) {
                System.out.printf("#  %s -> %d%n", inner.getKey(), inner.getValue());
            }
        }
    }
}