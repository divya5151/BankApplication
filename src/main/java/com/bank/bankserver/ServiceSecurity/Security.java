package com.bank.bankserver.ServiceSecurity;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Security {
    private int id;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
