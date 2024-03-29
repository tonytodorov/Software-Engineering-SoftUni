package bank.entities.bank;

import bank.common.ExceptionMessages;
import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static bank.common.ExceptionMessages.*;

public abstract class BaseBank implements Bank {

    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    protected BaseBank(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new IllegalArgumentException(BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<Client> getClients() {
        return clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return loans;
    }

    @Override
    public void addClient(Client client) {
        if (this.clients.size() > this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }

        clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return loans.stream()
                .mapToInt(Loan::getInterestRate)
                .sum();
    }

    @Override
    public String getStatistics() {

        String clientsInfo = "Clients: " + ((clients.isEmpty())
                ? "none"
                : clients.stream()
                    .map(Client::getName)
                    .collect(Collectors.joining(", ")));

        return String.format("Name: %s, Type: %s%n" +
                "%s%n" +
                "Loans: %d, Sum of interest rates: %d",
                this.name,
                this.getClass().getSimpleName(),
                clientsInfo,
                loans.size(),
                sumOfInterestRates());
    }
}
