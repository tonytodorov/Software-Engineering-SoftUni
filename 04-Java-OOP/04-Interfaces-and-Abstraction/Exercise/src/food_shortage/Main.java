//package food_shortage;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyerMap = new HashMap<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (data.length == 4) {
                String id = data[2];
                String birthdate = data[3];

                Buyer buyer = new Citizen(name, age, id, birthdate);
                buyerMap.put(name, buyer);
            } else {
                String group = data[2];

                Buyer buyer = new Rebel(name, age, group);
                buyerMap.put(name, buyer);
            }
        }

        String name = scanner.nextLine();
        int totalFood = 0;

        while (!"End".equals(name)) {
            Buyer buyer = buyerMap.get(name);

            if (buyer != null) {
                buyer.buyFood();
            }

            name = scanner.nextLine();
        }

        for (Map.Entry<String, Buyer> entry : buyerMap.entrySet()) {
            totalFood += entry.getValue().getFood();
        }

        System.out.println(totalFood);
    }
}
