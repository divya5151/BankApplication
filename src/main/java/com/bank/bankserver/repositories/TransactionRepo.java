package com.bank.bankserver.repositories;

import com.bank.bankserver.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
    public  Transaction getTransactionByTransactionid(Integer transactionid);
}
