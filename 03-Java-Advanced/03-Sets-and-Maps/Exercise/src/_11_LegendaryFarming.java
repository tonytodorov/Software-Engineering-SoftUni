import java.util.*;
import java.util.stream.Collectors;

public class _11_LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> items = new LinkedHashMap<>();
        Map<String, Integer> junkItems = new TreeMap<>();

        String firstItem = "Shadowmourne";
        String secondItem = "Valanyr";
        String thirdItem = "Dragonwrath";

        String firstToken = "shards";
        String secondToken = "fragments";
        String thirdToken = "motes";

        items.put(firstToken, 0);
        items.put(secondToken, 0);
        items.put(thirdToken, 0);

        boolean isFirstItemCreated = false;
        boolean isSecondItemCreated = false;
        boolean isThirdItemCreated = false;

        int neededTokens = 250;

        while (true) {
            List<String> input = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .collect(Collectors.toList());

            for (int i = 0; input.size() > 0; i++) {

                int value = Integer.parseInt(input.get(i));
                String type = input.get(i + 1).toLowerCase();

                if (type.equals("shards")) {
                    items.put(firstToken, items.get(firstToken) + value);
                } else if (type.equals("fragments")) {
                    items.put(secondToken, items.get(secondToken) + value);
                } else if (type.equals("motes")) {
                    items.put(thirdToken, items.get(thirdToken) + value);
                } else if (!junkItems.containsKey(type)) {
                    junkItems.put(type, value);
                } else {
                    junkItems.put(type, junkItems.get(type) + value);
                }

                int shardsValue = items.get(firstToken);
                int fragmentsValue = items.get(secondToken);
                int motesValue = items.get(thirdToken);

                if (shardsValue >= 250) {
                    isFirstItemCreated = true;
                    break;
                } else if (fragmentsValue >= 250) {
                    isSecondItemCreated = true;
                    break;
                } else if (motesValue >= 250) {
                    isThirdItemCreated = true;
                    break;
                }

                input.remove(i);
                input.remove(i);
                i = -1;
            }

            if (isFirstItemCreated || isSecondItemCreated || isThirdItemCreated) {
                break;
            }
        }

        if (isFirstItemCreated) {
            System.out.printf("%s obtained!%n", firstItem);
            items.put(firstToken, items.get(firstToken) - neededTokens);
        } else if (isSecondItemCreated) {
            System.out.printf("%s obtained!%n", secondItem);
            items.put(secondToken, items.get(secondToken) - neededTokens);
        } else {
            System.out.printf("%s obtained!%n", thirdItem);
            items.put(thirdToken, items.get(thirdToken) - neededTokens);
        }

        LinkedHashMap<String, Integer> sortedMap = items.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : junkItems.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}