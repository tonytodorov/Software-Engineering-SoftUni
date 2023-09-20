import java.util.Scanner;

public class _03_GamingStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();

        double price, totalSpent = 0.00;
        boolean isMoneyEnough = false;

        while (!command.equals("Game Time")){

            if(command.equals("OutFall 4")){
                price = 39.99;
            }else if(command.equals("CS: OG")){
                price = 15.99;
            }else if(command.equals("Zplinter Zell")){
                price = 19.99;
            }else if(command.equals("Honored 2")){
                price = 59.99;
            }else if(command.equals("RoverWatch")){
                price = 29.99;
            }else if(command.equals("RoverWatch Origins Edition")){
                price = 39.99;
            }else{
                System.out.println("Not Found");
                command = scanner.nextLine();
                continue;
            }

            if(price > budget){
                System.out.println("Too Expensive");
                command = scanner.nextLine();
                continue;
            }

            if(budget >= price){
                budget -= price;
                totalSpent += price;
                System.out.printf("Bought %s%n", command);
            }

            if(budget <= 0){
                isMoneyEnough = true;
                System.out.println("Out of money!");
                command = scanner.nextLine();
                continue;
            }

            command = scanner.nextLine();
        }

        if(isMoneyEnough){
            System.out.println();
        }else{
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, budget);
        }
    }
}
