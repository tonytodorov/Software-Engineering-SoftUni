package bank.account;

public class BankAccount {

    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int idCounter = 1;

    public BankAccount() {
        this.id = idCounter;
        idCounter += 1;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return interestRate * years * balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public int getId() {
        return id;
    }
}
