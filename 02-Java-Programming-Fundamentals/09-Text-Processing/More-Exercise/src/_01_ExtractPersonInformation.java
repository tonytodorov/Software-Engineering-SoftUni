import java.util.Scanner;

public class _01_ExtractPersonInformation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            int startNameIndex = text.indexOf("@");
            int endNameIndex = text.indexOf("|");

            int startIndexAge = text.indexOf("#");
            int endIndexAge = text.indexOf("*");

            String name = text.substring(startNameIndex + 1, endNameIndex);
            String age = text.substring(startIndexAge + 1, endIndexAge);

            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
