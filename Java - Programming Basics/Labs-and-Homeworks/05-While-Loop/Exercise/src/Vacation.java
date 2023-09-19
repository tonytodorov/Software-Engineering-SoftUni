import java.util.Scanner;

public class Vacation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countSpendDays = 0, countTotalDays = 0;
        double moneyForVacation, moneyCash, moneyForSpendOrSave;
        String spendOrSave;

        moneyForVacation = Double.parseDouble(scanner.nextLine());
        moneyCash = Double.parseDouble(scanner.nextLine());

        while (moneyCash < moneyForVacation && countSpendDays < 5){
            spendOrSave = scanner.nextLine();
            moneyForSpendOrSave = Double.parseDouble(scanner.nextLine());

            if("spend".equals(spendOrSave)){
                countSpendDays++;
                moneyCash -= moneyForSpendOrSave;
                if (moneyCash < 0){
                    moneyCash = 0;
                }
            }
            if("save".equals(spendOrSave)) {
                countSpendDays -= countSpendDays;
                moneyCash += moneyForSpendOrSave;
            }

            countTotalDays++;
        }

        if(countSpendDays == 5){
            System.out.printf("You can't save the money.%n%d", countSpendDays);
        }else{
            System.out.printf("You saved the money for %d days.", countTotalDays);
        }
    }
}
