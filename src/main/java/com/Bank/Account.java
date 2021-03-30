package com.Bank;

import com.Bank.enums.TransactionType;
import com.Bank.interfaces.*;
import java.util.ArrayList;

public class Account implements AccountService {
    int accountTotal;
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    TransactionDate transactionDate = new TransactionDate();

    public void deposit(int amount) {
        this.accountTotal += amount;
        Transaction transaction = new Transaction(transactionDate.getDate(), amount, accountTotal,
                TransactionType.DEPOSIT);
        this.transactions.add(0, transaction);
    };

    public void withdraw(int amount) {
        this.accountTotal -= amount;
        Transaction transaction = new Transaction(transactionDate.getDate(), amount, accountTotal,
                TransactionType.WITHDRAWL);
        this.transactions.add(0, transaction);
    };

    public void printStatement() {
        System.out.println("Date || Amount || Balance");
        for (Transaction transaction : this.transactions) {
            System.out.println(transaction.getLineItem());
        }
    }

    public void setTransactionDate(TransactionDate td) {
        this.transactionDate = td;
    }
}
