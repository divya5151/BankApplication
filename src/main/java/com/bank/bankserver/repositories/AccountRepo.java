package com.bank.bankserver.repositories;

import com.bank.bankserver.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {
    public Account getAccountByAccountId(Integer Accountid);
}
