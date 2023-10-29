import java.util.*;

public class _03_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<Double>> orders = new LinkedHashMap<>();

        while (!command.equals("buy")) {

            String[] data = command.split(" ");

            String product = data[0];
            double price = Double.parseDouble(data[1]);
            double quantity = Double.parseDouble(data[2]);

            if (!orders.containsKey(product)) {
                orders.put(product, new ArrayList<>());
                orders.get(product).add(quantity);
                orders.get(product).add(price);
            } else {
                orders.get(product).set(0, orders.get(product).get(0) + quantity);
                orders.get(product).set(1, price);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<Double>> entry: orders.entrySet()) {
            String key = entry.getKey();

            double quantity = orders.get(key).get(0);
            double price = orders.get(key).get(1);
            double totalPrice = quantity * price;

            System.out.printf("%s -> %.2f%n", key, totalPrice);
        }
    }
}
