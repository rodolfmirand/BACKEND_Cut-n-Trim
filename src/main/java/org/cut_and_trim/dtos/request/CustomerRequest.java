package org.cut_and_trim.dtos.request;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CustomerRequest {
    
    private String phoneNumber;

    private String name;

    private UUID barberShopID;

    public CustomerRequest(String phoneNumber, String name, UUID barberShopID){
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.barberShopID = barberShopID;
    }
}
