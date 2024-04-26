package com.bank.bankserver.services;

import com.bank.bankserver.entities.Account;

public interface AccountService {
    public Account AddAccount(Account ac);
    public Account getAccountByAccountId(Integer Accountid);
    public Account updateAccountByAccountId(Integer Accountid);
    public Account getAccountByAccountNo(Long AccountNo);

    public  Account updateAccount(Account a);
}
