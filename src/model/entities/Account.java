package model.entities;

import model.exceptions.DomainException;

public class Account {

    private Double balance;
    private final Double withdrawLimit;

    public Account(Double balance, Double withdrawLimit) {
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(Double amount) throws DomainException {
        if (amount > withdrawLimit) {
            throw new DomainException("The amount exceeds withdraw limit");
        } else if (amount > balance) {
            throw new DomainException("Not enough balance");
        } else {
            balance -= amount;
        }
    }
}
