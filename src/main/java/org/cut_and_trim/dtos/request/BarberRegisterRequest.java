package org.cut_and_trim.dtos.request;

import lombok.Getter;

@Getter
public class BarberRegisterRequest {
    
    private BarberRequest barber;

    private BarberShopRequest barberShop;

    public BarberRegisterRequest(BarberRequest barber, BarberShopRequest barberShop){
        this.barber = barber;
        this.barberShop = barberShop;
    }
}
