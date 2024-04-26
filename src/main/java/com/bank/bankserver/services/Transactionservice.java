package com.bank.bankserver.services;

import com.bank.bankserver.entities.Transaction;
import jakarta.servlet.http.HttpSession;

public interface Transactionservice {
    public Transaction addTransaction(Transaction t);
    public  Transaction getTransactionByTransactionid(Integer transactionid);
    public  boolean verifyOtp(String otp);
}
