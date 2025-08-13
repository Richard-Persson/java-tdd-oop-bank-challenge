package com.booleanuk.core;

public class SavingsAccount implements Account{


    private double balance;


    public SavingsAccount(){

    }


    @Override
    public boolean deposit(double amount) {
        if(amount < 0 ) return false;
        this.balance+=amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount < 0 ) return false;
        this.balance-=amount;

        return true;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

}
