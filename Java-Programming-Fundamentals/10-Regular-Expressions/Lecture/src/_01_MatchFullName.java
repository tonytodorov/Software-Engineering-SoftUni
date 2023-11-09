import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_MatchFullName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b([A-Z][a-z]{2,}) ([A-Z][a-z]{2,})\\b";
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
