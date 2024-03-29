package bank.entities.client;

import bank.common.ExceptionMessages;

import static bank.common.ExceptionMessages.*;

public abstract class BaseClient implements Client {

    private String name;
    private String ID;
    private int interest;
    private double income;

    protected BaseClient(String name, String ID, int interest, double income) {
        this.setName(name);
        this.setID(ID);
        this.interest = interest;
        this.setIncome(income);
    }

    private void setID(String ID) {
        if (null == ID || ID.trim().isEmpty()) {
            throw new IllegalArgumentException(CLIENT_ID_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.ID = ID;
    }

    private void setIncome(double income) {
        if (income <= 0) {
            throw new IllegalArgumentException(CLIENT_INCOME_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }

        this.income = income;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new IllegalArgumentException(CLIENT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int getInterest() {
        return interest;
    }

    @Override
    public double getIncome() {
        return income;
    }

    @Override
    public void increase() {
        if (getClass().getSimpleName().equals("Student")) {
            this.interest += 1;
        } else if (getClass().getSimpleName().equals("Adult")) {
            this.interest += 2;
        }
    }
}
