import java.util.*;
import java.util.stream.Collectors;

public class _03_OddOccurrences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        Map<String, Integer> oddOccurrence = new LinkedHashMap<>();

        for (String command: input) {

            String word = command.toLowerCase();

            if (!oddOccurrence.containsKey(word)) {
                oddOccurrence.put(word, 0);
            }

            oddOccurrence.put(word, oddOccurrence.get(word) + 1);
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: oddOccurrence.entrySet()) {

            String key = entry.getKey();
            int value = entry.getValue();

            if (value % 2 != 0) {
                result.add(key);
            }
        }

        System.out.println(String.join(", ", result));
    }
}
