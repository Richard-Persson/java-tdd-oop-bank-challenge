package com.booleanuk.core;

public class SavingsAccount implements Account{


    private double balance;


    public SavingsAccount(){

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
