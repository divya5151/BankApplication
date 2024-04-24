package com.bank.bankserver.repositories;

import com.bank.bankserver.entities.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankDetailRepo extends JpaRepository<BankDetails,Integer> {
    public BankDetails getBankDetailsByBranchid(Integer branchid);
}
