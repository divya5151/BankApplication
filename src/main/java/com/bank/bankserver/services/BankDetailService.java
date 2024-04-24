package com.bank.bankserver.services;

import com.bank.bankserver.entities.BankDetails;

public interface BankDetailService {
    public BankDetails AddDetails(BankDetails b);
    public BankDetails getBankDetailsByBranchid(Integer branchid);
}

