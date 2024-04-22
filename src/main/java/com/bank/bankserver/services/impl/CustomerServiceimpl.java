package com.bank.bankserver.services.impl;

import com.bank.bankserver.entities.Customer;
import com.bank.bankserver.repositories.CustomerRepo;
import com.bank.bankserver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CustomerServiceimpl implements CustomerService {
    @Autowired
    CustomerRepo cust;

    @Override
    public Customer AddCustomer(Customer c) {
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();
        c.setLogindate(date);
        c.setLogouttime(time);
        return cust.save(c);
    }

    @Override
    public  Customer getCustomerByCustid(Integer Custid) {
        return cust.getCustomerByCustid(Custid);
    }

}
