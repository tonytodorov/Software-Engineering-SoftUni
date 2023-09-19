import java.util.Scanner;

public class ReportSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int neededMoney, moneyForProduct, countPays = 0, sumMoney,
                sumMoneyCash = 0, sumMoneyCard = 0, sumMoneyInCash = 0, sumMoneyWithCard = 0,
                countPaymentsInCash = 0, countPaymentsWithCard = 0;
        String command;
        boolean isMoneyNeeded = false;

        neededMoney = Integer.parseInt(scanner.nextLine());
        command = scanner.nextLine();

        while (!command.equals("End")){
            moneyForProduct = Integer.parseInt(command);
            countPays++;

            if(countPays % 2 != 0){
                if(moneyForProduct > 100){
                    System.out.println("Error in transaction!");
                }else{
                    System.out.println("Product sold!");
                    countPaymentsInCash++;
                    sumMoneyCash += moneyForProduct;
                    sumMoneyInCash += sumMoneyCash;
                }
            }else{
                if(moneyForProduct < 10){
                    System.out.println("Error in transaction!");
                }else {
                    System.out.println("Product sold!");
                    countPaymentsWithCard++;
                    sumMoneyCard += moneyForProduct;
                    sumMoneyWithCard += sumMoneyCard;
                }
            }

            sumMoney = sumMoneyCash + sumMoneyCard;

            if(sumMoney >= neededMoney){
                isMoneyNeeded = true;
                break;
            }

            command = scanner.nextLine();
        }

        if(isMoneyNeeded){
            System.out.printf("Average CS: %.2f%n", (double)sumMoneyCash / countPaymentsInCash);
            System.out.printf("Average CC: %.2f", (double)sumMoneyCard / countPaymentsWithCard);
        }else{
            System.out.print("Failed to collect required money for charity.");
        }
    }
}
