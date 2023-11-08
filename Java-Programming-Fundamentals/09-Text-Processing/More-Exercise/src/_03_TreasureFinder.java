import java.util.Arrays;
import java.util.Scanner;

public class _03_TreasureFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] key = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("find")) {

            int countPosition = 0;
            String result = "";

            for (int i = 0; i < command.length(); i++) {
                char currentSign = command.charAt(i);

                if (countPosition > key.length - 1) {
                    countPosition = 0;
                }

                currentSign -= key[countPosition];

                countPosition++;
                result += currentSign;
            }

            int startTreasureType = result.indexOf("&");
            int endTreasureType = result.lastIndexOf("&");

            int startCoordinate = result.indexOf("<");
            int endCoordinate = result.indexOf(">");

            String type = result.substring(startTreasureType + 1, endTreasureType);
            String coordinate = result.substring(startCoordinate + 1, endCoordinate);

            System.out.printf("Found %s at %s%n", type, coordinate);
            command = scanner.nextLine();
        }
    }
}
