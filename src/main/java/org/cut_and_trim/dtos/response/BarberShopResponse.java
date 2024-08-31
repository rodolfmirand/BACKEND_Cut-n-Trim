package org.cut_and_trim.dtos.response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;

import lombok.Getter;

@Getter
public class BarberShopResponse {

    private UUID id;

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


    private List<BarberResponse> barbers = new ArrayList<>();

    public BarberShopResponse(BarberShop barberShop) {
        this.id = barberShop.getId();
        this.name = barberShop.getName();
        this.street = barberShop.getStreet();
        this.number = barberShop.getNumber();
        this.neighborhood = barberShop.getNeighborhood();
        this.city = barberShop.getCity();
        this.state = barberShop.getState();
        this.cep = barberShop.getCep();
        this.openingTime = barberShop.getOpeningTime();
        this.closingTime = barberShop.getClosingTime();
        this.lunchTimeStart = barberShop.getLunchTimeStart();
        this.lunchTimeEnd = barberShop.getLunchTimeEnd();
        if (barberShop.getBarbers() == null) {
            this.barbers = null;
        } else {
            for (Barber barber : barberShop.getBarbers()) {
                this.barbers.add(new BarberResponse(barber));
            }
        }
    }
}
