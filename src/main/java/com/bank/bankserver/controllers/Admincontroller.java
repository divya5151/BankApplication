package com.bank.bankserver.controllers;

import com.bank.bankserver.entities.Account;
import com.bank.bankserver.entities.BankDetails;
import com.bank.bankserver.entities.BankLocation;
import com.bank.bankserver.entities.Customer;
import com.bank.bankserver.services.impl.AccountServiceImpl;
import com.bank.bankserver.services.impl.BankDetailServiceImpl;
import com.bank.bankserver.services.impl.BankLocationServiceImpl;
import com.bank.bankserver.services.impl.CustomerServiceimpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class Admincontroller {
    @Autowired
    BankDetailServiceImpl bankdetail;

    @Autowired
    BankLocationServiceImpl banklocation;
    @Autowired
    CustomerServiceimpl custimpl;
    @Autowired
    AccountServiceImpl accimpl;

    @PostMapping("/AddDetail")
    public BankDetails AddDetail(@RequestBody BankDetails b) {

        return bankdetail.AddDetails(b);    }

    @PostMapping("/AddLocation")
    public BankLocation AddLocation(@RequestBody BankLocation l){

        return banklocation.AddBankLocation(l);
    }
    @DeleteMapping("/deleteuser/{CustId}")
    public Integer deletecust(@PathVariable Integer CustId){

        return custimpl.deleteCustomerByCustid(CustId);
    }
    @GetMapping("/getbankdetails/{branchid}")
    public BankDetails getdetails(@PathVariable Integer branchid){

        return bankdetail.getBankDetailsByBranchid(branchid);
    }
    @GetMapping("/getbanklocation/{banklocationid}")
    public ResponseEntity<BankLocation> getlocation(@PathVariable Integer banklocationid){
        BankLocation b=banklocation.getBankLocationByBanklocationid(banklocationid);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(b);
    }
 @PostMapping("/enablecust/{custid}")
    public Customer updatecust(@PathVariable Integer custid){

     return custimpl.updateCust(custid);
 }
    @PostMapping("/enableacc/{accountId}")
    public Account updateacc(@PathVariable Integer accountId){

        return accimpl.updateAccountByAccountId(accountId);
    }
    @GetMapping("/getcustomer/{custid}")
    public ResponseEntity<Customer> getcust(@PathVariable Integer custid){
       Customer c=custimpl.getCustomerByCustid(custid);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(c);
    }
    @GetMapping("/getAccount/{accountNo}")
    public ResponseEntity<Account> getcust(@PathVariable Long accountNo){
        Account a=accimpl.getAccountByAccountNo(accountNo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
    }
    @PutMapping("/updateDetail")
    public ResponseEntity<BankDetails> update(@RequestBody BankDetails b) {
         BankDetails b1=bankdetail.updateDetails(b);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(b1);
 }
    @PutMapping("/updatelocation")
    public ResponseEntity<BankLocation> update(@RequestBody BankLocation b) {
        BankLocation b1=banklocation.updatelocation(b);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(b1);
    }


}
