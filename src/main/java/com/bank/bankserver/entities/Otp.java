package com.bank.bankserver.entities;

import lombok.Data;

@Data

public class Otp {
    private  String otp;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
