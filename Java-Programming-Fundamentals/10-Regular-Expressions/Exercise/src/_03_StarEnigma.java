import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_StarEnigma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> input = new ArrayList<>();
        List<String> decryptedMessages = new ArrayList<>();

        TreeMap<String, String> attackedPlanets = new TreeMap<>();
        TreeMap<String, String> destroyedPlanets = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            input.add(text);
        }

        decryptMessages(input, decryptedMessages);
        matchTexts(decryptedMessages,attackedPlanets, destroyedPlanets);
        printResult(attackedPlanets, destroyedPlanets);
    }

    public static void decryptMessages(List<String> input, List<String> decryptedMessages) {

        for (String currentText : input) {
            char[] letter = currentText.toLowerCase(Locale.ROOT).toCharArray();

            int decryptionKey = 0;

            for (char currentChar : letter) {
                if (currentChar == 's' || currentChar == 't' || currentChar == 'a' || currentChar == 'r') {
                    decryptionKey += 1;
                }
            }

            String result = "";

            for (int j = 0; j < currentText.length(); j++) {
                char currentLetter = currentText.charAt(j);
                currentLetter -= decryptionKey;

                result += currentLetter;
            }

            decryptedMessages.add(result);
        }
    }

    public static void matchTexts(List<String> decryptedMessages,
                                  TreeMap<String, String> attackedPlanets,
                                  TreeMap<String,String> destroyedPlanets) {

        Pattern pattern = Pattern.compile("@(?<planetName>[A-Za-z]+)[^\\@\\-\\!\\:\\>]*:[^\\@\\-\\!\\:\\>0-9]*" +
                "(?<planetPopulation>[\\d]+)[^\\@\\-\\!\\:\\>]*![^\\@\\-\\!\\:\\>]" +
                "*(?<attackType>[AD])[^\\@\\-\\!\\:\\>]*![^\\@\\-\\!\\:\\>]*\\-\\>[^\\@" +
                "\\-\\!\\:\\>0-9]*(?<soldierCount>[\\d]+)");

        for (String currentMessage : decryptedMessages) {
            Matcher matcher = pattern.matcher(currentMessage);

            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                String attackType = matcher.group("attackType");

                for (int i = 0; i < planetName.length(); i++) {
                    char currentLetter = planetName.charAt(i);

                    if (!Character.isLetter(currentLetter)) {
                        planetName = planetName.replace(String.valueOf(currentLetter), "");
                    }
                }

                if (attackType.equals("A")) {
                    attackedPlanets.put(planetName, "");
                } else {
                    destroyedPlanets.put(planetName, "");
                }
            }
        }
    }

    public static void printResult(TreeMap<String, String> attackedPlanets,
                                   TreeMap<String, String> destroyedPlanets) {

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());

        for (Map.Entry<String, String> attackedPlanet : attackedPlanets.entrySet()) {
            System.out.printf("-> %s%n", attackedPlanet.getKey());
        }

        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());

        for (Map.Entry<String, String> destroyedPlanet : destroyedPlanets.entrySet()) {
            System.out.printf("-> %s%n", destroyedPlanet.getKey());
        }
    }
}
