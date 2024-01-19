import java.util.Scanner;

public class _03_ExtractFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\\\");
        String element = text[text.length - 1];

        String[] result = element.split("\\.");

        String fileName = result[0];
        String extension = result[1];

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s", extension);

    }
}
