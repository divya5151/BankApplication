package com.bank.bankserver.services.impl;

import com.bank.bankserver.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Random;
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    JavaMailSender mailsender;
    final Cookie c=new Cookie();
    final static String FROM= "divyassawant01@gmail.com";
    @Override
    public void sendOtp(String to) {
        Random r = new Random();
        int otp = r.nextInt(9999) + 1000;
        SimpleMailMessage sm=new SimpleMailMessage();
        String msg = "" + otp;
        c.setName(msg);
        sm.setTo(to);
        sm.setSubject("Otp verify");
        sm.setText("opt-" + msg);
        sm.setFrom(FROM);
        mailsender.send(sm);
    }

    @Override
    public boolean verifyotp1(String otp) {
        String s = c.getName();
        System.out.println(s);
        System.out.println(otp);
        if(otp.equals(s)) {
            c.setName("");
            Duration duration = Duration.ofMinutes(1);

            return true;
        } else {
            return false;
        }
    }
}
