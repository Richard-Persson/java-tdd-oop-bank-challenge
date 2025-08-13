package com.booleanuk.core;


public class Customer {

    private Account currentAccount;
    private Account savingsAccount;

    public Customer(){

    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public Account getSavingsAccount() {
        return savingsAccount;
    }

    public boolean createCurrentAccount(){
        if(currentAccount != null) return false;

        currentAccount = new CurrentAccount();
        return true;

    }

    public boolean createSavingsAccount(){

        if(savingsAccount != null) return false;

        savingsAccount = new SavingsAccount();

        return true;
    }

    public boolean deposit(Account ac, double amount){
        if(ac == null || amount < 0)
            return false;

        ac.deposit(amount);
        return true;

    }

    public boolean withdraw(Account ac, double amount){
        if(ac == null || amount < 0)
            return false;

        ac.deposit(amount);
        return true;
    }

    public BankStatement getBankStatements(Account ac) {
        return ac.getBankstatement();
    }

}
