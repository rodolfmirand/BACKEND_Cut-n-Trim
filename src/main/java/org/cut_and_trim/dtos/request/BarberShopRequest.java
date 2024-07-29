package org.cut_and_trim.dtos.request;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BarberShopRequest {

    private UUID barberID;
    
    private String name;

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private String cep;

    @Builder
    public BarberShopRequest(UUID barberID, String name, String street, String number, String neighborhood, String city,
            String state, String cep) {
        this.barberID = barberID;
        this.name = name;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    

}
