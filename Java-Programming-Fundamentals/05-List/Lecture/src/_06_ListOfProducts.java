import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_ListOfProducts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String product = scanner.nextLine();
            products.add(product);
        }

        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                String firstProd = products.get(i);
                String secondProd = products.get(j);

                char firstProdLetter = firstProd.charAt(0);
                char secondProdLetter = secondProd.charAt(0);

                if (firstProdLetter > secondProdLetter) {
                    String temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }

        int count = 1;

        for (String product : products) {
            System.out.printf("%d.%s%n", count, product);
            count++;
        }
    }
}
