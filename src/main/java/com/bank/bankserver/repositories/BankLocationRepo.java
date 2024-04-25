package com.bank.bankserver.repositories;

import com.bank.bankserver.entities.BankLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankLocationRepo extends JpaRepository<BankLocation,Integer> {
    public BankLocation getBankLocationByBanklocationid(Integer banklocationid);

}
