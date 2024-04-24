package com.bank.bankserver.services.impl;

import com.bank.bankserver.ServiceSecurity.Authentication;
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
        c.setEnable(false);
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();
        c.setLogindate(date);
        c.setLogouttime(time);
        return cust.save(c);
    }

    @Override
    public Customer getCustomerByCustid(Integer Custid) {
        return cust.getCustomerByCustid(Custid);
    }

    @Override
    public Integer deleteCustomerByCustid(Integer id) {
        int i = cust.deleteCustomerByCustid(id);
        System.out.println(i);
        if (i == 1) {
            return 1;
        } else {
            return 0;
        }


    }

    @Override
    public Customer getCustomerByCustemailAndCustpassword(String email, String password) {
        Customer cust1 = cust.getCustomerByCustemailAndCustpassword(email, password);
        if (cust1.isEnable()){
        return  cust1;
        }
        return null;
    }

    @Override
    public Customer updateCust(Integer custid) {
        Customer c=cust.getCustomerByCustid(custid);
        Customer c1=new Customer();
        c1.setCustid(c.getCustid());
        c1.setCustname(c.getCustname());
        c1.setCustemail(c.getCustemail());
        c1.setCustpassword(c.getCustpassword());
        c1.setCustcontact(c.getCustcontact());
        c1.setLogindate(c.getLogindate());
        c1.setLogouttime(c.getLogouttime());
        c1.setEnable(true);


        return cust.save(c1);
    }


}