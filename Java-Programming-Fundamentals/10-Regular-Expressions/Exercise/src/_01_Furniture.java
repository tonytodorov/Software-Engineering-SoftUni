import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_Furniture {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<name>[A-Za-z]+)<<(?<price>[\\d.]+)[!](?<quantity>[\\d]+)\\b";

        String command = scanner.nextLine();
        List<String> furniture = new ArrayList<>();

        while (!command.equals("Purchase")) {
            furniture.add(command);
            command = scanner.nextLine();
        }

        List<String> items = new ArrayList<>();
        double totalPrice = 0.00;

        for (String currentCommand : furniture) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(currentCommand);

            if (matcher.find()) {
                String names = matcher.group("name");
                String price = matcher.group("price");
                String quantity = matcher.group("quantity");
                
                items.add(names);

                double currentPrice = Double.parseDouble(price);
                int currentQuantity = Integer.parseInt(quantity);
                
                totalPrice += currentPrice * currentQuantity;
            }
        }

        System.out.println("Bought furniture:");

        for (String item : items) {
            System.out.println(item);
        }

        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
