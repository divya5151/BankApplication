package com.bank.bankserver.services.impl;

import com.bank.bankserver.entities.BankLocation;
import com.bank.bankserver.repositories.BankDetailRepo;
import com.bank.bankserver.repositories.BankLocationRepo;
import com.bank.bankserver.services.BankLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankLocationServiceImpl implements BankLocationService {
    @Autowired
    BankLocationRepo location;
    @Override
    public BankLocation AddBankLocation(BankLocation l) {
        return location.save(l);
    }

    @Override
    public BankLocation updatelocation(BankLocation l) {
        return location.save(l);
    }

    @Override
    public BankLocation getBankLocationByBanklocationid(Integer banklocationid) {
        return location.getBankLocationByBanklocationid(banklocationid);
    }
}
