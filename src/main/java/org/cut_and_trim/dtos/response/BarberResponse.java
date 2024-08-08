package org.cut_and_trim.dtos.response;

import java.util.UUID;

import org.cut_and_trim.models.Barber;

import lombok.Getter;

@Getter
public class BarberResponse {

    private UUID id;

    private String name;

    private String phoneNumber;

    public BarberResponse(Barber barber) {
        this.id = barber.getId();
        this.name = barber.getName();
        this.phoneNumber = barber.getPhoneNumber();
    }
}
