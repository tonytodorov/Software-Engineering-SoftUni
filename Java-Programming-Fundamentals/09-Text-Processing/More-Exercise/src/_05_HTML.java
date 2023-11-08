import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05_HTML {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();

        String command = scanner.nextLine();

        List<String> comments = new ArrayList<>();

        while (!command.equals("end of comments")) {
            comments.add(command);
            command = scanner.nextLine();
        }

        System.out.printf("<h1>%n    %s%n</h1>%n", title);
        System.out.printf("<article>%n    %s%n</article>%n", content);

        for (String comment : comments) {
            System.out.printf("<div>%n    %s%n</div>%n", comment);
        }
    }
}
