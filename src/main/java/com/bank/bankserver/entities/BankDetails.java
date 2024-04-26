package com.bank.bankserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int branchid;
    private String bankname;
    private String bankIFSC;


    /*@OneToOne(mappedBy = "bankdetails")*/
/*
   @Transient
*/
    @OneToMany(mappedBy = "bankdetails")
    @JsonIgnore
    private List<Account> account;

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    @OneToOne(mappedBy = "bankdetails")
    @JsonManagedReference
    private BankLocation bancklocation;
    public int getBranchid() {
        return branchid;
    }



    public BankLocation getBancklocation() {
        return bancklocation;
    }

    public void setBancklocation(BankLocation bancklocation) {
        this.bancklocation = bancklocation;
    }

    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankIFSC() {
        return bankIFSC;
    }

    public void setBankIFSC(String bankIFSC) {
        this.bankIFSC = bankIFSC;
    }
}
