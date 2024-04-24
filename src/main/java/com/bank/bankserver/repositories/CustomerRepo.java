package com.bank.bankserver.repositories;

import com.bank.bankserver.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    public Customer getCustomerByCustid(Integer id);
    @Transactional
    public Integer deleteCustomerByCustid(Integer id);
    public Customer getCustomerByCustemailAndCustpassword(String email,String password);

}
