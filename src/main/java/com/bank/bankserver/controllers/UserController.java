package com.bank.bankserver.controllers;

import com.bank.bankserver.ServiceSecurity.Authentication;
import com.bank.bankserver.entities.Account;
import com.bank.bankserver.entities.Customer;
import com.bank.bankserver.entities.Transaction;
import com.bank.bankserver.services.impl.AccountServiceImpl;
import com.bank.bankserver.services.impl.CustomerServiceimpl;
import com.bank.bankserver.services.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Authentication auth;
    @Autowired
    TransactionServiceImpl transimpl;
    @Autowired
    Authentication authentication;

    @PostMapping("/Addcust")
    public Customer add(@RequestBody Customer c) {

        return custimpl.AddCustomer(c);
    }

    @PostMapping("/Addacc")
    public Account Addaccount(@RequestBody Account ac) {
        boolean b = authentication.authorized();
        if (b) {
            return Accimpl.AddAccount(ac);
        }
        return null;
    }

    @PostMapping("/AddTransaction")
    public Transaction add(@RequestBody Transaction t) {
        boolean b = authentication.authorized();
        if (b) {
            return transimpl.addTransaction(t);
        }
        return null;
    }

    @GetMapping("/getAccount/{Accountid}")
    public Account getAccount(@PathVariable Integer Accountid) {
        boolean b = authentication.authorized();
        if (b) {
            return Accimpl.getAccountByAccountId(Accountid);
        }
        return null;
    }

    @GetMapping("/getcustomer/{Custid}")
    public Customer getcust(@PathVariable Integer Custid) {
        boolean b = authentication.authorized();
        if (b) {
            return custimpl.getCustomerByCustid(Custid);
        }
        return null;
    }

    @PostMapping("/login")
    public Customer getemailandpassword(@RequestBody Customer c) {

        Customer cust = custimpl.getCustomerByCustemailAndCustpassword(c.getCustemail(), c.getCustpassword());
        auth.setEmail(cust.getCustemail());
        auth.setPassword(cust.getCustpassword());
        return cust;

    }

    @GetMapping("/getTransaction/{transactionid}")
    public ResponseEntity<Transaction> getTransactionbyid(@PathVariable Integer transactionid) {
        boolean b = authentication.authorized();
        if (b) {
            Transaction t = transimpl.getTransactionByTransactionid(transactionid);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(t);
        }
        return null;
    }

    @PutMapping("/updatecust")
    public ResponseEntity<Customer> updatecust(@RequestBody Customer c) {
        boolean b = authentication.authorized();
        if (b) {
            Customer c1 = custimpl.updateCustomer(c);
            return ResponseEntity.status(HttpStatus.CREATED).body(c1);
        }
        return null;
    }
}
