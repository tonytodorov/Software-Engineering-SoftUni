import java.util.Scanner;

public class _03_Substring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String removedWord = scanner.nextLine();
        String text = scanner.nextLine();

        text = text.replace(removedWord, "");

        System.out.println(text);
    }
}
