package com.bank.bankserver.services.impl;

import com.bank.bankserver.entities.Account;
import com.bank.bankserver.repositories.AccountRepo;
import com.bank.bankserver.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepo acc;
    @Override
    public Account AddAccount(Account ac) {
        return acc.save(ac);
    }



    @Override
    public Account getAccountByAccountId(Integer Accountid) {
        return acc.getAccountByAccountId(Accountid);
    }
}
