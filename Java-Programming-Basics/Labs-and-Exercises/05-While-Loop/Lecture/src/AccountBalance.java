import java.util.Scanner;

public class AccountBalance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text;
        double moneyAdded, sum = 0;
        text = scanner.nextLine();

        while (!text.equals("NoMoreMoney")){
            moneyAdded = Double.parseDouble(text);

            if(moneyAdded < 0){
                System.out.println("Invalid operation!");
                break;
            }

            System.out.printf("Increase: %.2f\n", moneyAdded);
            sum += moneyAdded;
            text = scanner.nextLine();
        }
        System.out.printf("Total: %.2f", sum);
    }
}
