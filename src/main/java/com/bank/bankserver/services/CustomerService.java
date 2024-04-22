package com.bank.bankserver.services;

import com.bank.bankserver.entities.Customer;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CustomerService {
    public Customer AddCustomer(Customer c);
    public Customer getCustomerByCustid(Integer Custid);

    public Integer deleteCustomerByCustid(Integer id);
}
