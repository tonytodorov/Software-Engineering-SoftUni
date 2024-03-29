package bank.core;

import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static bank.common.ConstantMessages.*;
import static bank.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private LoanRepository loans;
    private Collection<Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;

        if (type.equals("CentralBank")) {
            bank = new CentralBank(name);
        } else if (type.equals("BranchBank")) {
            bank = new BranchBank(name);
        } else {
            throw new IllegalArgumentException(INVALID_BANK_TYPE);
        }


        banks.add(bank);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;

        if (type.equals("StudentLoan")) {
            loan = new StudentLoan();
        } else if (type.equals("MortgageLoan")) {
            loan = new MortgageLoan();
        } else {
            throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }

        loans.addLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan currentLoan = loans.findFirst(loanType);

        if (null == currentLoan) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        }

        Bank currentBank = banks.stream()
                .filter(bank -> bank.getName().equals(bankName))
                .findFirst()
                .get();

        currentBank.addLoan(currentLoan);
        loans.removeLoan(currentLoan);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client;

        if (clientType.equals("Student")) {
            client = new Student(clientName, clientID, income);
        } else if (clientType.equals("Adult")) {
            client = new Adult(clientName, clientID, income);
        } else {
            throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }

        Bank currentBank = banks.stream()
                .filter(bank -> bank.getName().equals(bankName))
                .findFirst()
                .get();

        if (clientType.equals("Adult") && currentBank.getClass().getSimpleName().equals("CentralBank")) {
            currentBank.addClient(client);
        } else if (clientType.equals("Student") && currentBank.getClass().getSimpleName().equals("BranchBank")) {
            currentBank.addClient(client);
        } else {
            return UNSUITABLE_BANK;
        }

        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank currentBank = banks.stream()
                .filter(bank -> bank.getName().equals(bankName))
                .findFirst()
                .get();

        double loansSum = currentBank.getLoans()
                .stream()
                .mapToDouble(Loan::getAmount)
                .sum();

        double incomeSum = currentBank.getClients()
                .stream()
                .mapToDouble(Client::getIncome)
                .sum();

        double funds = loansSum + incomeSum;

        return String.format(FUNDS_BANK, bankName, funds);
    }

    @Override
    public String getStatistics() {
        return banks.stream()
                .map(Bank::getStatistics)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
