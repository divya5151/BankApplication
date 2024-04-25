package com.bank.bankserver.services;

import com.bank.bankserver.entities.BankLocation;
import com.bank.bankserver.repositories.BankLocationRepo;
import org.springframework.beans.factory.annotation.Autowired;

public interface BankLocationService {

    public BankLocation AddBankLocation(BankLocation l);
    public BankLocation updatelocation(BankLocation l);
    public BankLocation getBankLocationByBanklocationid(Integer banklocationid);
}

