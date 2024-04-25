package com.bank.bankserver.services;

import com.bank.bankserver.entities.Transaction;

public interface Transactionservice {
    public Transaction addTransaction(Transaction t);
    public  Transaction getTransactionByTransactionid(Integer transactionid);
}
