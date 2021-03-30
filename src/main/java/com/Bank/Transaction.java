package com.Bank;

import com.Bank.enums.TransactionType;

public class Transaction {
    private String date;
    private int amount;
    private int total;
    private TransactionType type;

    public Transaction(String date, int amount, int total, TransactionType type) {
        this.date = date;
        this.total = total;
        this.amount = amount;
        this.type = type;
    }

    public String getLineItem() {
        int adjustedAmount = this.type == TransactionType.DEPOSIT ? this.amount : this.amount * -1;

        return this.date + " || " + adjustedAmount + " || " + total;
    }
}
