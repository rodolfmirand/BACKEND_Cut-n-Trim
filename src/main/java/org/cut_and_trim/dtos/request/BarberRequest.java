package org.cut_and_trim.dtos.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BarberRequest {
    
    private String name;

    private String phoneNumber;

    public BarberRequest(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
