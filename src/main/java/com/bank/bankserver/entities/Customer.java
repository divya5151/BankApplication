package com.bank.bankserver.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custid;
    private String custname;
    @Column(unique = true)
    private String custcontact;
    @Column(unique = true)
    private  String custemail;

    private  String custpassword;
    private  String logindate;
    private  String logouttime;
    @OneToOne(mappedBy = "customer",orphanRemoval = true)
    @JsonManagedReference
    private  Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustcontact() {
        return custcontact;
    }

    public void setCustcontact(String custcontact) {
        this.custcontact = custcontact;
    }

    public String getCustemail() {
        return custemail;
    }

    public void setCustemail(String custemail) {
        this.custemail = custemail;
    }

    public String getCustpassword() {
        return custpassword;
    }

    public void setCustpassword(String custpassword) {
        this.custpassword = custpassword;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }

    public String getLogouttime() {
        return logouttime;
    }

    public void setLogouttime(String logouttime) {
        this.logouttime = logouttime;
    }
}
