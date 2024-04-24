package com.bank.bankserver.ServiceSecurity;

import com.bank.bankserver.entities.Customer;
import com.bank.bankserver.services.CustomerService;
import com.bank.bankserver.services.impl.CustomerServiceimpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Authentication {
    @Autowired
    CustomerService cust;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public  boolean authorized(){
        boolean b=false;
        String email1 = getEmail();
        String password1 = getPassword();
        Customer c = cust.getCustomerByCustemailAndCustpassword(email1, password1);
        if(c!=null){
           b=true;
        }
        return  b;
    }
}
