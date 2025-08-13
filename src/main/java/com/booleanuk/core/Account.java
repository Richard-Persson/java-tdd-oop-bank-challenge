package com.booleanuk.core;

public interface Account {


    BankStatement getBankstatement();
    boolean deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    Enum<Branches> getBranch();
    void setBranch(Enum<Branches> newBranch);
    boolean requestOverdraft(double amount);


}
