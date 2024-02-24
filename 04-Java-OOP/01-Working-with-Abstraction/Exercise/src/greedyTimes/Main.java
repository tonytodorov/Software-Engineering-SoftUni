package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long input = Long.parseLong(scanner.nextLine());
        String[] vault = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> pack = new LinkedHashMap<>();

        for (int i = 0; i < vault.length; i += 2) {

            String name = vault[i];
            long quantity = Long.parseLong(vault[i + 1]);

            String typeOfItem = typeOfItem(name);

            long result = pack.values()
                    .stream()
                    .map(Map::values)
                    .flatMap(Collection::stream)
                    .mapToLong(e -> e)
                    .sum() + quantity;

            if (typeOfItem.equals("")) {
                continue;
            } else if (input < result) {
                continue;
            }

            switch (typeOfItem) {
                case "Gem":
                    if (!pack.containsKey(typeOfItem)) {
                        if (pack.containsKey("Gold")) {
                            if (quantity > pack.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (pack.get(typeOfItem).values().stream().mapToLong(e -> e).sum() + quantity > pack.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!pack.containsKey(typeOfItem)) {
                        if (pack.containsKey("Gem")) {
                            if (quantity > pack.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (pack.get(typeOfItem).values().stream().mapToLong(e -> e).sum() + quantity > pack.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!pack.containsKey(typeOfItem)) {
                pack.put(typeOfItem, new LinkedHashMap<>());
            }

            if (!pack.get(typeOfItem).containsKey(name)) {
                pack.get(typeOfItem).put(name, 0L);
            }

            pack.get(typeOfItem).put(name, pack.get(typeOfItem).get(name) + quantity);
        }


        printMap(pack);
    }


    private static String typeOfItem(String name) {

        String typeOfItem = "";

        if (name.length() == 3) {
            typeOfItem = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            typeOfItem = "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            typeOfItem = "Gold";
        }

        return typeOfItem;
    }


    private static void printMap(Map<String, LinkedHashMap<String, Long>> pack) {

        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : pack.entrySet()) {

            long sumValues = entry.getValue()
                    .values()
                    .stream()
                    .mapToLong(l -> l)
                    .sum();

            System.out.printf("<%s> $%s%n", entry.getKey(), sumValues);

            entry.getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }
}