package com.bank.bankserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BankLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int banklocationid;
    private String city;
    private String state;
    private  String country;
    @OneToOne()
   @JsonBackReference
    private BankDetails bankdetails;

    public int getBanklocationid() {
        return banklocationid;
    }

    public void setBanklocationid(int banklocationid) {
        this.banklocationid = banklocationid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
