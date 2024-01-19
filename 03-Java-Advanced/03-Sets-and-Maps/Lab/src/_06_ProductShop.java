import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_ProductShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<String, Map<String, Double>> products = new TreeMap<>();

        while (!text.equals("Revision")) {

            String[] tokens = text.split(",\\s+");
            String shopName = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            if (!products.containsKey(shopName)) {
                products.put(shopName, new LinkedHashMap<>());
            }

            products.get(shopName).put(product, price);
            text = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry: products.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());

            Map<String, Double> nestedMap = entry.getValue();

            for (Map.Entry<String, Double> innerMap : nestedMap.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", innerMap.getKey(), innerMap.getValue());
            }
        }
    }
}
