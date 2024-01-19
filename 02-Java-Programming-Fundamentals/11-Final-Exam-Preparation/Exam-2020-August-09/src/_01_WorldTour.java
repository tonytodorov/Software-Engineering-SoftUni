import java.util.Scanner;

public class _01_WorldTour {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Travel")) {

            String[] tokens = command.split(":");
            String operation = tokens[0];

            if (operation.equals("Add Stop")) {
                text = addText(tokens, text);
            } else if (operation.equals("Remove Stop")) {
                text = removeText(tokens, text);
            } else if (operation.equals("Switch")) {
                String oldString = tokens[1];
                String newString = tokens[2];

                if (text.contains(oldString)) {
                    text = text.replace(oldString, newString);
                }
            }

            System.out.println(text);
            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", text);
    }

    public static boolean isIndexValid(String text, int index) {
        return index >= 0 && index <= text.length() - 1;
    }

    public static String addText(String[] tokens, String text) {

        int index = Integer.parseInt(tokens[1]);
        String addText = tokens[2];

        boolean isIndexValid = isIndexValid(text, index);

        String result = "";

        if (isIndexValid) {
            for (int i = 0; i < text.length(); i++) {
                char letter = text.charAt(i);

                if (i == index) {
                    result += addText;
                }

                result += letter;
            }
        }

        return result;
    }

    public static String removeText(String[] tokens, String text) {

        int startIndex = Integer.parseInt(tokens[1]);
        int endIndex = Integer.parseInt(tokens[2]);

        boolean isStartIndexValid = isIndexValid(text, startIndex);
        boolean isEndIndexValid = isIndexValid(text, endIndex);

        if (isStartIndexValid && isEndIndexValid) {
            String currentWord = text.substring(startIndex, endIndex + 1);
            text = text.replace(currentWord, "");
        }

        return text;
    }

}
