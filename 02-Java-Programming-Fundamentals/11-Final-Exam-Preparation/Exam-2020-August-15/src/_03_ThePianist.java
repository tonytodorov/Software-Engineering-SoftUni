import java.util.*;

public class _03_ThePianist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> composers = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String[] tokens = input.split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            if (!composers.containsKey(piece)) {
                composers.put(piece, new ArrayList<>());
                composers.get(piece).add(composer);
                composers.get(piece).add(key);
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {

            String[] tokens = command.split("\\|");
            String operation = tokens[0];

            if (operation.equals("Add")) {
                addPiece(composers, tokens);
            } else if (operation.equals("Remove")){
                removePiece(composers, tokens);
            } else if (operation.equals("ChangeKey")) {
                changeKey(composers, tokens);
            }

            command = scanner.nextLine();
        }

        print(composers);
    }

    public static void addPiece(Map<String, List<String>> composers, String[] tokens) {

        String piece = tokens[1];
        String composer = tokens[2];
        String key = tokens[3];

        if (!composers.containsKey(piece)) {
            composers.put(piece, new ArrayList<>());
            composers.get(piece).add(composer);
            composers.get(piece).add(key);
            System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
        } else {
            System.out.printf("%s is already in the collection!%n", piece);
        }
    }

    public static void removePiece(Map<String, List<String>> composers, String[] tokens) {

        String piece = tokens[1];

        if (composers.containsKey(piece)) {
            composers.remove(piece);
            System.out.printf("Successfully removed %s!%n", piece);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }

    }

    public static void changeKey(Map<String, List<String>> composers, String[] tokens) {

        String piece = tokens[1];
        String newKey = tokens[2];

        if (composers.containsKey(piece)) {
            composers.get(piece).remove(1);
            composers.get(piece).add(newKey);
            System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }

    public static void print(Map<String, List<String>> composers) {

        for (Map.Entry<String, List<String>> entry: composers.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(),
                    entry.getValue().get(0),
                    entry.getValue().get(1));
        }
    }
}
