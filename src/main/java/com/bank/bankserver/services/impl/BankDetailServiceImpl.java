package com.bank.bankserver.services.impl;

import com.bank.bankserver.entities.BankDetails;
import com.bank.bankserver.repositories.BankDetailRepo;
import com.bank.bankserver.services.BankDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankDetailServiceImpl implements BankDetailService {
    @Autowired
    BankDetailRepo bank;

    @Override
    public BankDetails AddDetails(BankDetails b) {
        return bank.save(b);
    }

    @Override
    public BankDetails getBankDetailsByBranchid(Integer branchid) {
        return bank.getBankDetailsByBranchid(branchid);
    }

    @Override
    public BankDetails updateDetails(BankDetails b) {
        return bank.save(b);
    }
}
