package com.booleanuk.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {

    private Account currentAccount;
    private Account savingsAccount;
    Map<Account,BankStatement> bankStatements = new HashMap<>();

    public Customer(){

    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public Account getSavingsAccount() {
        return savingsAccount;
    }

    public boolean createCurrentAccount(){
        if(currentAccount != null)
            return false;

        currentAccount = new CurrentAccount();
        BankStatement b = new BankStatement();
        bankStatements.put(currentAccount,b);
        return true;

    }

    public boolean createSavingsAccount(){

        if(savingsAccount != null)
            return false;

        savingsAccount = new SavingsAccount();
        BankStatement b = new BankStatement();
        bankStatements.put(currentAccount,b);
        return true;
    }

    public boolean deposit(Account ac, double amount){
        if(ac == null || amount < 0)
            return false;

        Transaction t = new Transaction(amount,ac.getBalance()+amount,"Debit");
        bankStatements.get(ac).add(t);
        return true;

    }

    public boolean withdraw(Account ac, double amount){
        if(ac == null || amount < 0)
            return false;

        Transaction t = new Transaction(amount,ac.getBalance()-amount, "Credit");
        bankStatements.get(ac).add(t);
        return true;
    }

    public BankStatement getBankStatements(Account ac) {
        return bankStatements.get(ac);
    }

}
