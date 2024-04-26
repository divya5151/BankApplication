package com.bank.bankserver.controllers;

import com.bank.bankserver.ServiceSecurity.Authentication;
import com.bank.bankserver.entities.Account;
import com.bank.bankserver.entities.Customer;
import com.bank.bankserver.entities.Otp;
import com.bank.bankserver.entities.Transaction;
import com.bank.bankserver.services.impl.AccountServiceImpl;
import com.bank.bankserver.services.impl.CustomerServiceimpl;
import com.bank.bankserver.services.impl.EmailServiceImpl;
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
    @Autowired
    EmailServiceImpl emailimpl;

    @PostMapping("/Addcust")
    public ResponseEntity<Customer> add(@RequestBody Customer c) {

        Customer customer = custimpl.AddCustomer(c);

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PostMapping("/Addacc")
    public ResponseEntity<Account> Addaccount(@RequestBody Account ac) {
        boolean b = authentication.authorized();
        if (b) {
            Account account = Accimpl.AddAccount(ac);
            return ResponseEntity.status(HttpStatus.CREATED).body(account);
        }
        return null;
    }

    @PostMapping("/AddTransaction")
    public ResponseEntity<Transaction> add(@RequestBody Transaction t) {
        boolean b = authentication.authorized();
        if (b) {
            Transaction transaction = transimpl.addTransaction(t);
            return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
        }
        return null;
    }

    @PostMapping("/verifyotp")
    public void verify(@RequestBody String otp) {
        emailimpl.verifyotp1(otp);
    }

    @GetMapping("/getAccount/{Accountid}")
    public ResponseEntity<Account> getAccount(@PathVariable Integer Accountid) {
        boolean b = authentication.authorized();
        if (b) {
            Account accountByAccountId = Accimpl.getAccountByAccountId(Accountid);
            return ResponseEntity.status(HttpStatus.CREATED).body(accountByAccountId);
        }
        return null;
    }

    @GetMapping("/getcustomer/{Custid}")
    public ResponseEntity<Customer> getcust(@PathVariable Integer Custid) {
        boolean b = authentication.authorized();
        if (b) {
            Customer customerByCustid = custimpl.getCustomerByCustid(Custid);
            return ResponseEntity.status(HttpStatus.CREATED).body(customerByCustid);
        }
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> getemailandpassword(@RequestBody Customer c) {

        Customer cust = custimpl.getCustomerByCustemailAndCustpassword(c.getCustemail(), c.getCustpassword());
        auth.setEmail(cust.getCustemail());
        auth.setPassword(cust.getCustpassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(cust);

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

    @PutMapping("/updateAccount")
    public ResponseEntity<Account> updatecust(@RequestBody Account a) {
        boolean b = authentication.authorized();
        if (b) {
            Account a1 = Accimpl.updateAccount(a);
            return ResponseEntity.status(HttpStatus.CREATED).body(a1);
        }
        return null;
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyotp(@RequestBody Otp otp) {
        System.out.println("my otp"+otp.getOtp());
        boolean b = transimpl.verifyOtp(otp.getOtp());
        if (b) {
            return ResponseEntity.ok("verified successfully");
        }
        return ResponseEntity.ok("verified successfully");
    }
}