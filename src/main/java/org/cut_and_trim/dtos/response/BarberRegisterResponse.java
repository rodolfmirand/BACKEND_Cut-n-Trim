package org.cut_and_trim.dtos.response;

import org.cut_and_trim.models.Barber;

import lombok.Getter;

@Getter
public class BarberRegisterResponse {
    
    private BarberResponse barber;

    private BarberShopResponse barberShop;

    public BarberRegisterResponse(Barber barber){
        this.barber = new BarberResponse(barber);
        this.barberShop = new BarberShopResponse(barber.getBarberShop());
    }
}
