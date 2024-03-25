import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_DestinationMapper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([\\=\\/])(?<destination>[A-Z]{1}[A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> destinations = new ArrayList<>();

        while (matcher.find()) {
            destinations.add(matcher.group("destination"));
        }

        int travelPoints = 0;

        for (String destination : destinations) {
            travelPoints += destination.length();
        }

        System.out.print("Destinations: ");

        for (int i = 0; i < destinations.size(); i++) {
            System.out.print(destinations.get(i));

            if (i < destinations.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.printf("%nTravel Points: %d", travelPoints);
    }
}
