import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double amountDeposited, annualInterestRate, totalRate, rateForMonth, total;
        int termOfDeposit;

        amountDeposited = Double.parseDouble(scanner.nextLine());
        termOfDeposit = Integer.parseInt(scanner.nextLine());
        annualInterestRate = scanner.nextDouble();

        totalRate = amountDeposited * (annualInterestRate / 100);
        rateForMonth = totalRate / 12;
        total = amountDeposited + termOfDeposit * rateForMonth;

        System.out.println(total);
    }
}
