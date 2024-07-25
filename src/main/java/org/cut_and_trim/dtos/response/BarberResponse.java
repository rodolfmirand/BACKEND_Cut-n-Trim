package org.cut_and_trim.dtos.response;

import java.util.UUID;

import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;

import lombok.Getter;

@Getter
public class BarberResponse {

    private UUID id;
    
    private String name;

    private String username;

    private String email;

    private String password;

    private BarberShop barberShop;

    public BarberResponse(Barber barber){
        this.id = barber.getId();
        this.name = barber.getName();
        this.username = barber.getUsername();
        this.email = barber.getEmail();
        this.password = barber.getPassword();
        this.barberShop = barber.getBarberShop();
    }
}
