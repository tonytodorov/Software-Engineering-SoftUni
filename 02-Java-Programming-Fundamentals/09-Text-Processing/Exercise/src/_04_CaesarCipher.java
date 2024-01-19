import java.util.Scanner;

public class _04_CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("");
        String result = "";

        for (String currentWord : text) {
            char letter = currentWord.charAt(0);
            result += ((char) (letter + 3));
        }

        System.out.println(result);
    }
}
