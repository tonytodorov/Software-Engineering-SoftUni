import java.util.*;
import java.util.stream.Collectors;

public class _01_CountCharsString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        Map<Character, Integer> countChars = new LinkedHashMap<>();

        for (String word: input) {

            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);

                if (!countChars.containsKey(letter)) {
                    countChars.put(letter, 0);
                }

                countChars.put(letter, countChars.get(letter) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry: countChars.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
