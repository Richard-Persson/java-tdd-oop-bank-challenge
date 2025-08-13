package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {


    private LocalDate date = LocalDate.now();
    private double amount;
    private double balance;

    public Transaction(double amount, double balance) {
        this.amount = amount;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
