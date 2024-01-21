package bank.account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<Integer, BankAccount> bank = new HashMap<>();

        while (!"End".equals(command)) {
            String[] data = command.split("\\s+");
            String operation = data[0];

            if ("Create".equals(operation)) {
                createAccount(bank);
            } else if ("Deposit".equals(operation)) {
                deposit(bank, data);
            } else if ("SetInterest".equals(operation)) {
                setInterest(Double.parseDouble(data[1]));
            } else if ("GetInterest".equals(operation)){
                getInterest(bank, data);
            }

            command = scanner.nextLine();
        }
    }

    private static void getInterest(Map<Integer, BankAccount> bank, String[] data) {
        int id = Integer.parseInt(data[1]);
        int years = Integer.parseInt(data[2]);
        BankAccount account = bank.get(id);

        if (bank.containsKey(id)) {
            System.out.printf("%.2f%n", account.getInterest(years));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }

    private static void createAccount(Map<Integer, BankAccount> bank) {
        BankAccount account = new BankAccount();
        bank.put(account.getId(), account);

        System.out.printf("Account ID%d created%n", account.getId());
    }

    private static void deposit(Map<Integer, BankAccount> bank, String[] data) {
        int id = Integer.parseInt(data[1]);
        int amount = Integer.parseInt(data[2]);

        BankAccount account = bank.get(id);

        if (account != null) {
            bank.get(id).deposit(amount);
            System.out.printf("Deposited %s to ID%d%n", amount, id);
        } else {
            System.out.println("Account does not exist");
        }
    }
}
