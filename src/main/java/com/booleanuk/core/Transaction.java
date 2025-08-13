package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {


    private LocalDate date = LocalDate.now();
    private double amount;
    private double balance;
    private Enum<AccountOperation> type;

    public Transaction(double amount, double balance, Enum<AccountOperation>type) {
        this.amount = amount;
        this.balance = balance;
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }


    public double getAmount() {
        return amount;
    }


    public LocalDate getDate() {
        return date;
    }


    public Enum<AccountOperation> getType() {
        return type;
    }

    public void setType(Enum<AccountOperation> type) {
        this.type = type;
    }
}
