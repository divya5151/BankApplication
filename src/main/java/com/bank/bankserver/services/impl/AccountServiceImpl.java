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
        ac.setEnable(false);
        return acc.save(ac);
    }



    @Override
    public Account getAccountByAccountId(Integer Accountid) {
        return acc.getAccountByAccountId(Accountid);
    }

    @Override
    public Account updateAccountByAccountId(Integer accountid) {
        Account a=acc.getAccountByAccountId(accountid);
        Account a1=new Account();
        a1.setAccountId(a.getAccountId());
        a1.setAccountNo(a.getAccountNo());
        a1.setAccountbalance(a.getAccountbalance());
        a1.setCustomer(a.getCustomer());
        a1.setEnable(true);
        return acc.save(a1);
    }

    @Override
    public Account getAccountByAccountNo(Long AccountNo) {
        return acc.getAccountByAccountNo(AccountNo);
    }

    @Override
    public Account updateAccount(Account a) {
        int accountid=a.getAccountId();
        Account a1=acc.getAccountByAccountId(accountid);
        a1.setAccountId(a.getAccountId());
        a1.setAccountNo(a.getAccountNo());
        a1.setAccountbalance(a.getAccountbalance());
        a1.setCustomer(a.getCustomer());
        return acc.save(a);
    }
}
