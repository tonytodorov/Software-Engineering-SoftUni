import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_ReplaceRepeatingChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        char[] chars = text.toCharArray();

        List<Character> characterList = new ArrayList<>();

        for (char currentChar : chars) {
            characterList.add(currentChar);
        }

        for (int i = 1; i < characterList.size(); i++) {
            char currentChar = characterList.get(i);
            char previousChar = characterList.get(i - 1);

            if (currentChar == previousChar) {
                characterList.remove(i);
                i -= 1;
            }
        }

        for (Character character : characterList) {
            System.out.print(character);
        }
    }
}
