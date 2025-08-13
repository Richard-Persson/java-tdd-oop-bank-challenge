package com.booleanuk.core;

public class CurrentAccount implements Account{

    private double balance;

    public CurrentAccount(){

    }




    @Override
    public boolean deposit(double amount) {
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public double getBalance() {
        return 0;
    }
}
