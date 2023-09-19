import java.util.Scanner;

public class TouristShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        int countProducts = 0;
        double budget, priceForProduct, sum = 0.00;
        boolean isMoneyFinish = false;
        budget = Double.parseDouble(scanner.nextLine());
        command = scanner.nextLine();

        while (!command.equals("Stop")){
            priceForProduct = Double.parseDouble(scanner.nextLine());
            countProducts++;
            if(countProducts % 3 == 0){
                priceForProduct *= 0.5;
            }
            sum += priceForProduct;

            if(sum > budget){
                isMoneyFinish = true;
                break;
            }

            command = scanner.nextLine();
        }
        if(isMoneyFinish){
            System.out.printf("You don't have enough money!%nYou need %.2f leva!", sum - budget);
        }else{
            System.out.printf("You bought %d products for %.2f leva.", countProducts, sum);
        }
    }
}
