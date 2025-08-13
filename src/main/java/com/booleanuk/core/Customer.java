package com.booleanuk.core;

import java.util.List;
import java.util.Map;

public class Customer {

    List<Account> accounts;
    Map<Account,BankStatement> bankStatements;

    public Customer(){

    }

    public boolean createCurrentAccount(){

        return false;
    }

    public boolean createSavingsAccount(){

        return false;
    }

    public boolean deposit(Account ac, double amount){

        return false;
    }

    public boolean withdraw(Account ac, double amount){

        return false;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Map<Account, BankStatement> getBankStatements() {
        return bankStatements;
    }

    public void setBankStatements(Map<Account, BankStatement> bankStatements) {
        this.bankStatements = bankStatements;
    }
}
