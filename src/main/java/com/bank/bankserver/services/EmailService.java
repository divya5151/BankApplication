package com.bank.bankserver.services;

public interface EmailService {
    public void sendOtp(String to);
    public boolean verifyotp1(String otp);

}
