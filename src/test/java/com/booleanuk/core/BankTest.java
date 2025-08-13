package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.booleanuk.core.AccountOperation.*;

public class BankTest {

    private Account currentAccount = new CurrentAccount();

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

        BankStatement b = customer.getBankStatement(customer.getCurrentAccount());
        Assertions.assertTrue(b.getTransactions().size()>0);
    }

    @Test
    void getBalance(){

        Account ac = new CurrentAccount();
        ac.deposit(1000);
        Assertions.assertEquals(1000,ac.getBalance());
    }


    @Test
    void checkTransactions(){


        Account account = new CurrentAccount();

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        BankStatement b = account.getBankstatement();
        List<Transaction> tList = b.getTransactions();
        Transaction depositTransaction1 = tList.get(0);
        Transaction depositTransaction2 = tList.get(1);
        Transaction withdrawTransaction = tList.get(2);

        Assertions.assertEquals(1000,depositTransaction1.getBalance());
        Assertions.assertEquals(1000,depositTransaction1.getAmount());
        Assertions.assertEquals(2000,depositTransaction2.getAmount());
        Assertions.assertEquals(3000,depositTransaction2.getBalance());
        Assertions.assertEquals(2500,withdrawTransaction.getBalance());
        Assertions.assertEquals(500,withdrawTransaction.getAmount());


    }


    @Test
    void print(){

        Transaction t1 = new Transaction(1000,1500,DEPOSIT);
        Transaction t2 = new Transaction(500,1000,WITHDRAW);

        BankStatement bankStatement = new BankStatement();
        bankStatement.add(t1);
        bankStatement.add(t2);

        bankStatement.printStatement();
        Assertions.assertTrue(true);

    }


}
