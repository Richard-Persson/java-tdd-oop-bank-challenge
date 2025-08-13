package com.booleanuk.core;

public class CurrentAccount implements Account{

    private double balance;
    private final BankStatement bankStatement = new BankStatement();

    public CurrentAccount(){
        balance = calculateBalance();

    }

    @Override
    public BankStatement getBankstatement() {
        return this.bankStatement;
    }

    @Override
    public boolean deposit(double amount) {
        if(amount < 0 ) return false;
        Transaction t = new Transaction(amount,this.balance+amount, "Debit");
        this.bankStatement.add(t);
        this.balance+=amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        double negative = amount * -1;
        if(amount < 0 || this.balance-amount < 0 ) return false;
        Transaction t = new Transaction(negative,this.balance + negative, "Credit");
        bankStatement.add(t);
        this.balance-=amount;

        return true;
    }

    @Override
    public double getBalance() {
        return this.balance;
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
