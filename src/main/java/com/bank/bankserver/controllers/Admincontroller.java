package com.bank.bankserver.controllers;

import com.bank.bankserver.entities.BankDetails;
import com.bank.bankserver.entities.BankLocation;
import com.bank.bankserver.services.impl.BankDetailServiceImpl;
import com.bank.bankserver.services.impl.BankLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class Admincontroller {
    @Autowired
    BankDetailServiceImpl bankdetail;

    @Autowired
    BankLocationServiceImpl banklocation;

    @PostMapping("/AddDetail")
    public BankDetails AddDetail(@RequestBody BankDetails b) {

        return bankdetail.AddDetails(b);    }

    @PostMapping("/AddLocation")
    public BankLocation AddLocation(@RequestBody BankLocation l){

        return banklocation.AddBankLocation(l);
    }
}
