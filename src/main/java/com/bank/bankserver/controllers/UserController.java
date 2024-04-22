package com.bank.bankserver.controllers;

import com.bank.bankserver.entities.Account;
import com.bank.bankserver.entities.Customer;
import com.bank.bankserver.entities.Transaction;
import com.bank.bankserver.services.impl.AccountServiceImpl;
import com.bank.bankserver.services.impl.CustomerServiceimpl;
import com.bank.bankserver.services.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class UserController {
    @Autowired
    CustomerServiceimpl custimpl;
    @Autowired
    AccountServiceImpl Accimpl;

    @Autowired
    TransactionServiceImpl transimpl;

    @PostMapping("/Addcust")
    public Customer add(@RequestBody Customer c){

        return custimpl.AddCustomer(c);
    }
    @PostMapping("/Addacc")
    public Account Addaccount(@RequestBody Account ac){

        return Accimpl.AddAccount(ac);
    }
    @PostMapping("/AddTransaction")
    public Transaction add(@RequestBody Transaction t){

        return transimpl.addTransaction(t);
    }
    @GetMapping("/getAccount/{Accountid}")
    public Account getAccount(@PathVariable Integer Accountid){
        return Accimpl.getAccountByAccountId(Accountid);
    }
    @GetMapping("/getcustomer/{Custid}")
    public Customer getcust(@PathVariable Integer Custid)
    {
        return custimpl.getCustomerByCustid(Custid) ;
    }

   }

