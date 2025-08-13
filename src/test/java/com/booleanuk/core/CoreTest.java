package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoreTest {

    private Customer customer = new Customer();
    private Account currentAccount = new CurrentAccount();
    private Account savingsAccount = new SavingsAccount();

    @BeforeEach
    void setup(){

    }

    @Test
    void deposit(){

        currentAccount.deposit(25);
        Assertions.assertEquals(25,currentAccount.getBalance());
    }

    @Test
    void withdraw(){

        currentAccount.deposit(50);
        currentAccount.withdraw(25);
        Assertions.assertEquals(25,currentAccount.getBalance());
    }

    @Test
    void depositNegative(){
        boolean answer = currentAccount.deposit(-50);
        Assertions.assertFalse(answer);
    }

    @Test
    void withdrawNegative(){

        currentAccount.deposit(50);
        boolean answer = currentAccount.withdraw(100);
        Assertions.assertFalse(answer);
    }

    @Test
    void createAccount(){

        Customer c1 = new Customer();
        Assertions.assertTrue(c1.createCurrentAccount());
        Assertions.assertTrue(c1.createSavingsAccount());
    }

    @Test
    void createAccountTwice(){

        Customer c1 = new Customer();
        c1.createCurrentAccount();
        c1.createSavingsAccount();
        Assertions.assertFalse(c1.createCurrentAccount());
        Assertions.assertFalse(c1.createSavingsAccount());
    }


    @Test
    void createTransaction(){

        Customer customer = new Customer();
        customer.createCurrentAccount();
        customer.deposit(customer.getCurrentAccount(), 50);

        BankStatement b = customer.getBankStatements(customer.getCurrentAccount());
        Assertions.assertTrue(b.getTransactions().size()>0);
    }


    @Test
    void print(){

        Transaction t1 = new Transaction(1000,1500,"Debit");
        Transaction t2 = new Transaction(500,1000,"Credit");

        BankStatement bankStatement = new BankStatement();
        bankStatement.add(t1);
        bankStatement.add(t2);

        bankStatement.printStatement();
        Assertions.assertTrue(true);

    }


}
