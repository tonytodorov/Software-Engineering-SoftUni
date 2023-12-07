import java.util.*;

public class _09_ForceBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<String>> game = new LinkedHashMap<>();

        while (!command.equals("Lumpawaroo")) {

            String[] data = command.split(" ");

            String elements = getElements(data);
            String delimiter = getDelimiter(data);

            if (delimiter.equals("|")) {
                String[] tokens = elements.split(" \\| ");
                String forceSide = tokens[0];
                String forceUser = tokens[1];

                boolean isUserExisting = isUserExisting(game, forceUser);

                if (!game.containsKey(forceSide) && !isUserExisting) {
                    game.put(forceSide, new ArrayList<>());
                    game.get(forceSide).add(forceUser);
                } else if(!isUserExisting){
                    game.get(forceSide).add(forceUser);
                }
            }

            if (delimiter.equals("->")) {
                String[] tokens = elements.split(" -> ");
                String forceUser = tokens[0];
                String forceSide = tokens[1];

                boolean isUserExisting = isUserExisting(game, forceUser);

                if (!isUserExisting) {
                    game.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                } else {
                    game.get(forceSide).add(forceUser);
                    game.remove(forceUser);
                }

            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry: game.entrySet()) {

            if (entry.getKey().isEmpty()) {
                continue;
            }

            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());

            for (String member: entry.getValue()) {
                System.out.printf("! %s%n", member);
            }
        }
    }

    public static boolean isUserExisting(Map<String, List<String>> game, String user) {

        for (Map.Entry<String, List<String>> entry: game.entrySet()) {
            for (String member: entry.getValue()) {
                if (member.equals(user)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static String getElements(String[] data) {

        StringBuilder result = new StringBuilder();

        for (String element : data) {
            result.append(element).append(" ");
        }

        return result.toString();
    }

    public static String getDelimiter(String[] data) {

        String delimiter = "";

        for (String element : data) {
            if (element.equals("|") || element.equals("->")) {
                delimiter = element;
                break;
            }
        }

        return delimiter;
    }
}
