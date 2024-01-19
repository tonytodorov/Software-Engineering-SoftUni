import java.util.Scanner;

public class _07_VendingMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyword = scanner.nextLine();

        double coins, sum = 0;

        while (!keyword.equals("Start")){
            coins = Double.parseDouble(keyword);

            if(coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2){
                sum += coins;
            } else{
                System.out.printf("Cannot accept %.2f%n", coins);
            }

            keyword = scanner.nextLine();
        }

        String product = scanner.nextLine();

        while (!product.equals("End")){

            double price = 0.00;

            if(product.equals("Nuts")){
                price = 2.00;
            } else if(product.equals("Water")){
                price = 0.7;
            } else if(product.equals("Crisps")){
                price = 1.5;
            } else if(product.equals("Soda")){
                price = 0.8;
            } else if(product.equals("Coke")){
                price = 1.0;
            } else{
                System.out.println("Invalid product");
                product = scanner.nextLine();
                continue;
            }

            if(sum < price) {
                System.out.println("Sorry, not enough money");
            } else{
                sum -= price;
                System.out.printf("Purchased %s%n", product);
            }

            product = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sum);
    }
}
