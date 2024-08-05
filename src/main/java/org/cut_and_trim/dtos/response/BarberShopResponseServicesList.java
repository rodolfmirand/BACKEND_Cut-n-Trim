package org.cut_and_trim.dtos.response;

import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Service;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BarberShopResponseServicesList {

    private List<Service> services = new ArrayList<Service>();

    public BarberShopResponseServicesList(BarberShop barberShop) {

        if (barberShop.getServices().isEmpty()) {
            this.services = null;
        } else {
            for (Service service : barberShop.getServices()) {
                this.services.add(service);
            }
        }
    }

    public BarberShopResponseServicesList(List<Service> services){
        this.services = services;
    }
}
