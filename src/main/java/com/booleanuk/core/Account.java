package com.booleanuk.core;

public interface Account {


    BankStatement getBankstatement();
    boolean deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();


}
