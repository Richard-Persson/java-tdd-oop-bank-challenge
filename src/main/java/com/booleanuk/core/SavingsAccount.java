package com.booleanuk.core;

import static com.booleanuk.core.AccountOperation.DEPOSIT;
import static com.booleanuk.core.AccountOperation.WITHDRAW;

public class SavingsAccount implements Account{


    private double balance;
    private Enum<Branches> branch;
    private final BankStatement bankStatement = new BankStatement();

    public SavingsAccount(){
        balance = calculateBalance();

    }

    @Override
    public BankStatement getBankstatement() {
        return this.bankStatement;
    }

    @Override
    public boolean deposit(double amount) {
        if(amount < 0 ) return false;
        Transaction t = new Transaction(amount,this.balance+amount,DEPOSIT);
        this.bankStatement.add(t);
        this.balance+=amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        double negative = amount * -1;
        if(amount < 0 || this.balance-amount < 0 ) return false;
        Transaction t = new Transaction(negative,this.balance + negative, WITHDRAW);
        bankStatement.add(t);
        this.balance-=amount;

        return true;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public Enum<Branches> getBranch() {
        return this.branch;
    }

    @Override
    public void setBranch(Enum<Branches> newBranch) {
        this.branch = newBranch;
    }

    @Override
    public boolean requestOverdraft(double amount) {
        return false;
    }

    private double calculateBalance(){

        if(bankStatement.getTransactions().isEmpty())
            return 0;

        double sum = 0;
        for (Transaction t : bankStatement.getTransactions())
            sum += t.getAmount();

        return sum;

    }

}
