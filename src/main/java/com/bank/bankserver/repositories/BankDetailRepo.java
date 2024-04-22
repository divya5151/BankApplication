package com.bank.bankserver.repositories;

import com.bank.bankserver.entities.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailRepo extends JpaRepository<BankDetails,Integer> {
}
