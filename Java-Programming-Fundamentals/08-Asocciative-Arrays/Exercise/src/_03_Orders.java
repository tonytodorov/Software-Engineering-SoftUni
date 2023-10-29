import java.util.*;

public class _03_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> orders = new LinkedHashMap<>();

        while (!command.equals("buy")) {

            String[] data = command.split(" ");

            String product = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            if (!orders.containsKey(product)) {
                orders.put(product, quantity);
            } else {
                orders.replace(product, quantity);
            }




            orders.put(product, orders.get(product));

            command = scanner.nextLine();
        }


    }
}
