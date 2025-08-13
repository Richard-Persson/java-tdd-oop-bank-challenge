package com.booleanuk.core;


import java.util.ArrayList;
import java.util.List;
import static com.booleanuk.core.AccountOperation.*;

public class BankStatement {

    private List<Transaction> transactions = new ArrayList<>();

    public BankStatement(){

    }

    public void printStatement(){

        String x = String.format("%-15s || %-15s || %-15s || %s" , "date", "credit", "debit", "balance" );
        System.out.println(x);

        for (Transaction t : transactions){
            if(t.getType()==DEPOSIT)
                System.out.printf("%-15s || %-15s || %-15s || %s%n", t.getDate(), 0 , t.getAmount(), t.getBalance() );
            else
                System.out.printf("%-15s || %-15s || %-15s || %s%n", t.getDate(), t.getAmount() ,0 , t.getBalance() );

        }
    }


    public boolean add(Transaction t){
        return transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
