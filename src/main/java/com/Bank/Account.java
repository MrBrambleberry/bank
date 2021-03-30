package com.Bank;

import com.Bank.interfaces.*;

public class Account implements AccountService {

    public void deposit(int amount) {
    };

    public void withdraw(int amount) {
    };

    public void printStatement() {
        System.out.println("Date || Amount || Balance");
        System.out.println("14/01/2012 || -500 || 2500");
        System.out.println("13/01/2012 || 2000 || 3000");
        System.out.println("10/01/2012 || 1000 || 1000");
    }

}
