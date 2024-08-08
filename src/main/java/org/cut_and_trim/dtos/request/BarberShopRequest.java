package org.cut_and_trim.dtos.request;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;

@Data
public class BarberShopRequest {

    private UUID ownerID;

    private String name;

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private String cep;

    private int openingTime;

    private int closingTime;

    private int lunchTimeStart;

    private int lunchTimeEnd;

    public BarberShopRequest(UUID ownerID, String name, String street, String number, String neighborhood, String city,
            String state, String cep, int openingTime, int closingTime, int lunchTimeStart, int lunchTimeEnd) {
        this.ownerID = ownerID;
        this.name = name;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.lunchTimeStart = lunchTimeStart;
        this.lunchTimeEnd = lunchTimeEnd;
    }
}
