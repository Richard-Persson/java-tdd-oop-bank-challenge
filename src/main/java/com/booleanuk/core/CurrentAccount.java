package com.booleanuk.core;
import static com.booleanuk.core.AccountOperation.*;
import static com.booleanuk.core.Branches.*;

public class CurrentAccount implements Account{

    private double balance;
    private Enum<Branches> branch;
    private final BankStatement bankStatement = new BankStatement();
    private final double OVERDRAFTLIMIT = -3000;

    public CurrentAccount(){
        balance = calculateBalance();
        this.branch = OSLO;

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
        if(amount < 0 || this.balance-amount < 0 ) return false;
        Transaction t = new Transaction(amount,this.balance - amount, WITHDRAW);
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

    private double calculateBalance(){

        if(bankStatement.getTransactions().isEmpty())
            return 0;

        double sum = 0;
        for (Transaction t : bankStatement.getTransactions())
            sum += t.getAmount();

        return sum;

    }

    public boolean requestOverdraft(double amount){
        return this.balance-amount < OVERDRAFTLIMIT;
    }
}
