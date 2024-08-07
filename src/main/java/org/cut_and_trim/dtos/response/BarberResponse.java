package org.cut_and_trim.dtos.response;

import java.util.UUID;

import org.cut_and_trim.models.Barber;

import lombok.Getter;

@Getter
public class BarberResponse {

    private UUID id;

    private String name;

    private String email;

    private String password;

    private BarberShopResponse barberShop;

    public BarberResponse(Barber barber) {
        this.id = barber.getId();
        this.name = barber.getName();
        this.email = barber.getEmail();
        this.password = barber.getPassword();
        if (barber.getBarberShop() == null) {
            this.barberShop = null;
        } else {
            this.barberShop = new BarberShopResponse(barber.getBarberShop());
        }
    }
}
