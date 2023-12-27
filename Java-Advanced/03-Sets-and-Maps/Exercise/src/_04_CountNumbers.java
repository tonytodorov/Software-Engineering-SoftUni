import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            if (!symbols.containsKey(letter)) {
                symbols.put(letter, 0);
            }

            symbols.put(letter, symbols.get(letter) + 1);
        }

        for (Map.Entry<Character, Integer> entry: symbols.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
