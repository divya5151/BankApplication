package com.bank.bankserver.services.impl;

import com.bank.bankserver.entities.Account;
import com.bank.bankserver.entities.Customer;
import com.bank.bankserver.entities.Transaction;
import com.bank.bankserver.entities.TransactionStatus;
import com.bank.bankserver.repositories.AccountRepo;
import com.bank.bankserver.repositories.CustomerRepo;
import com.bank.bankserver.repositories.TransactionRepo;
import com.bank.bankserver.services.Transactionservice;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service

public class TransactionServiceImpl implements Transactionservice {
    @Autowired
    TransactionRepo transrepo;
    @Autowired
    AccountRepo Accrepo;

    TransactionStatus ts;
    @Autowired
    HttpSession session;
    @Autowired
    EmailServiceImpl email;
    @Autowired
    CustomerRepo cust;


    @Override
    public Transaction addTransaction(Transaction t) {
        int accountId1 = t.getAccount().getAccountId();
        Account acc = Accrepo.getAccountByAccountId(accountId1);
        

        if (acc.isEnable()) {
            String time = LocalTime.now().toString();
            String date = LocalDate.now().toString();
            t.setTransactiontime(time);
            t.setTransactiondate(date);
            int accountId = t.getAccount().getAccountId();
            Account a = Accrepo.getAccountByAccountId(accountId);
            Float availableAmount = a.getAccountbalance();
            if (t.getTransactionstatus() == TransactionStatus.Credited) {
                float totalAmount = availableAmount + t.getTransactionAmount();
                a.setAccountbalance(totalAmount);

                Accrepo.save(a);
                transrepo.save(t);
            } else if (t.getTransactionstatus() == TransactionStatus.Debited) {
                if (availableAmount >= t.getTransactionAmount()) {


                    float totalAmount = availableAmount - t.getTransactionAmount();
                    a.setAccountbalance(totalAmount);
                    session.setAttribute("a",a);
                    session.setAttribute("t",t);
                    System.out.println("sending otp");
                    Integer custid = a.getCustomer().getCustid();
                    Customer customerByCustid = cust.getCustomerByCustid(custid);

                    email.sendOtp(customerByCustid.getCustemail());
//                   /* Accrepo.save(a);
//                    transrepo.save(t);*/
                }
            }

            return t;

        }
        return null;
    }

    @Override
    public Transaction getTransactionByTransactionid(Integer transactionid) {
        return transrepo.getTransactionByTransactionid(transactionid) ;
    }

    @Override
    public boolean verifyOtp(String otp) {
       Account acc = (Account) session.getAttribute("a");
        Transaction tr =(Transaction) session.getAttribute("t");
        boolean verifyotp = email.verifyotp1(otp);
        if(verifyotp){
            Accrepo.save(acc);
            transrepo.save(tr);
            return true;
        }
        return false;
    }

}

