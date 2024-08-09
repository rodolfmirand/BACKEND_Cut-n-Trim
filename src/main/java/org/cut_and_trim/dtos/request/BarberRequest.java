package org.cut_and_trim.dtos.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BarberRequest {
    
    private String name;

    private String phoneNumber;

    private String email;

    private String password;

    public BarberRequest(String name, String phoneNumber, String email, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}
