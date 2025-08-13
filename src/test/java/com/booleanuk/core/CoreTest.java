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

        customer.deposit(currentAccount, 50);

        BankStatement b = customer.getBankStatements().get(currentAccount);
        BankStatement b2 = customer.getBankStatements().get(savingsAccount);

        Assertions.assertTrue(b.getTransactions().size()>0);
        Assertions.assertNull(b2.getTransactions());

    }


}
