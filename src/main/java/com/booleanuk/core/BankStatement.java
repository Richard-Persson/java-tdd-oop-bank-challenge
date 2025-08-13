package com.booleanuk.core;


import java.util.ArrayList;
import java.util.List;

public class BankStatement {

    private List<Transaction> transactions = new ArrayList<>();

    public BankStatement(){

    }

    public void printStatement(){

    }


    public boolean add(Transaction t){
        return false;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
