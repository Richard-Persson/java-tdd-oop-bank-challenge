package com.booleanuk.core;


import java.util.ArrayList;
import java.util.List;

public class BankStatement {

    private List<Transaction> transactions = new ArrayList<>();

    public BankStatement(){

    }

    public void printStatement(){

        for (Transaction t : transactions){
            System.out.print(t.getDate() + "  " + t.getAmount() + " "  + t.getBalance());
            System.out.println("\n");
        }
    }


    public boolean add(Transaction t){
        return transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
