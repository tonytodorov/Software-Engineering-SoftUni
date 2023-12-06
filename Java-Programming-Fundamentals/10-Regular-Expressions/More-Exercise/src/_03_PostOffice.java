import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _03_PostOffice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> parts = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        Pattern key = Pattern.compile("([\\#\\$\\%\\*\\&])([A-Z]+)\\1");
        Matcher matcher = key.matcher(parts.get(0));

        String keyPattern = "";

        if (matcher.find()) {
            keyPattern = matcher.group(2);
        }

        Pattern numbers = Pattern.compile("");

        for (int i = 0; i < keyPattern.length(); i++) {
        }
    }
}
