package com.bank.bankserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(unique = true)
    private Long accountNo;

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    private float accountbalance;
    @OneToOne
    @JsonBackReference
    private Customer customer;
    @OneToOne
    @JsonManagedReference
    private  BankDetails bankdetails;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BankDetails getBankdetails() {
        return bankdetails;
    }

    public void setBankdetails(BankDetails bankdetails) {
        this.bankdetails = bankdetails;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    @OneToMany(mappedBy = "account" ,cascade =CascadeType.REMOVE)
    @JsonManagedReference
    private List<Transaction> transaction;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(float accountbalance) {
        this.accountbalance = accountbalance;
    }
}
