import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_AdAstra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#\\|])(?<itemName>[A-Za-z\\s]+)\\1" +
                "(?<expirationDate>[\\d]{2}\\/[\\d]{2}\\/[\\d]{2})\\1" +
                "(?<calories>[\\d]+)\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> items = new ArrayList<>();
        int totalCalories = 0;

        while (matcher.find()) {
            String itemName = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            String calories = matcher.group("calories");

            items.add(String.format("Item: %s, Best before: %s, Nutrition: %s",
                    itemName, expirationDate, calories));

            totalCalories += Integer.parseInt(calories);
        }

        int leftFood = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", leftFood);

        if (leftFood > 0) {
            items.forEach(System.out::println);
        }
    }
}
