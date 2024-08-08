package org.cut_and_trim.dtos.request;

import lombok.Getter;

@Getter
public class OwnerRegisterBarberShopRequest {
    
    private OwnerRequest owner;

    private BarberShopRequest barberShop;

    public OwnerRegisterBarberShopRequest(OwnerRequest ownerRequest, BarberShopRequest barberShopRequest){
        this.owner = ownerRequest;
        this.barberShop = barberShopRequest;
    }
}
