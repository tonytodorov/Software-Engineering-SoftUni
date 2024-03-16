package solid;

import solid.products.Chocolate;
import solid.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalorieCalculator calorieCalculator = new CalorieCalculator();
        List<Product> productList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] token = input.split("\\s+");

            String type = token[0];
            int quantity = Integer.parseInt(token[1]);

            Product product;

            if ("Chocolate".equals(type)) {
                product = new Chocolate(quantity);
                productList.add(product);
            }

            input = scanner.nextLine();
        }


        System.out.println("Total calories: " + calorieCalculator.sum(productList));
        System.out.println("Average calories: " + calorieCalculator.average(productList));
    }
}
