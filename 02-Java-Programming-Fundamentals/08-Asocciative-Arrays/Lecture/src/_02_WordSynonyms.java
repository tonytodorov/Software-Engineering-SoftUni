import java.util.*;

public class _02_WordSynonyms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<String>> wordSynonym = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!wordSynonym.containsKey(word)) {
                wordSynonym.put(word, new ArrayList<>());
            }

            wordSynonym.get(word).add(synonym);
        }

        for (Map.Entry<String, ArrayList<String>> entry: wordSynonym.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
