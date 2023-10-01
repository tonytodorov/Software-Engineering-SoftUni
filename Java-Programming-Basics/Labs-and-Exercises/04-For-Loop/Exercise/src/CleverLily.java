import java.util.Scanner;

public class CleverLily {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int years, moneyForEvenBirthday = 0, moneyForBrother = 0, numberOfToys = 0,
                priceForOneToy, totalMoneyFromBirthday = 0;
        double priceForWashMachine, totalMoneyFromToys, total;

        years = Integer.parseInt(scanner.nextLine());
        priceForWashMachine = Double.parseDouble(scanner.nextLine());
        priceForOneToy = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= years; i++) {
            if(i % 2 == 0){
                moneyForBrother++;
                moneyForEvenBirthday = moneyForEvenBirthday + 10;
                totalMoneyFromBirthday += moneyForEvenBirthday;

            }else{
                numberOfToys++;
            }
        }

        totalMoneyFromToys = numberOfToys * priceForOneToy;
        total = (totalMoneyFromBirthday + totalMoneyFromToys) - moneyForBrother;

        if(total >= priceForWashMachine){
            System.out.printf("Yes! %.2f", total - priceForWashMachine);
        }else{
            System.out.printf("No! %.2f", Math.abs(total - priceForWashMachine));
        }
    }
}
