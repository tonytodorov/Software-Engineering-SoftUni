import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_SoftUniBarIncome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<String> matches = new ArrayList<>();

        Pattern pattern = Pattern.compile("%(?<customer>[A-Z][a-z]+)%[^\\$\\.\\%\\|0-9]*" +
                "\\<(?<product>\\w+)\\>[^\\$\\.\\%\\|0-9]*\\|" +
                "(?<count>[0-9]+)\\|([^\\$\\.\\%\\|0-9]*" +
                "(?<price>[\\d.]+))\\$");

        double totalPrice = 0.00;

        while (!command.equals("end of shift")) {
            matches.add(command);
            command = scanner.nextLine();
        }

        for (String text : matches) {
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                String count = matcher.group("count");
                String price = matcher.group("price");

                customer = customer.replace("%", "");
                product = product.replace("<", "").replace(">", "");
                count = count.replace("|", "");
                price = price.replace("$", "");

                int currentCount = Integer.parseInt(count);
                double currentPrice = Double.parseDouble(price);

                totalPrice += currentCount * currentPrice;
                System.out.printf("%s: %s - %.2f%n", customer, product, currentCount * currentPrice);
            }
        }

        System.out.printf("Total income: %.2f", totalPrice);
    }
}
