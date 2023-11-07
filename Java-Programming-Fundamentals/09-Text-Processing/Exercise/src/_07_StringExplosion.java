import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_StringExplosion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> text = Arrays.stream(input.split("")).collect(Collectors.toList());

        int leftStrength = 0;

        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).equals(">")) {
                int strength = Integer.parseInt(text.get(i + 1)) + leftStrength;

                for (int j = 0; j < strength; j++) {

                    if (i + 1 > text.size() - 1) {
                        break;
                    }

                    String element = text.get(i + 1);

                    if (element.equals(">")) {
                        leftStrength = strength - j;
                        break;
                    }

                    text.remove(i + 1);
                }
            }
        }

        String result = "";

        for (String ch : text) {
            result += ch;
        }

        System.out.println(result);
    }
}
