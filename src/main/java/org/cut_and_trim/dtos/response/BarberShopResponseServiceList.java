package org.cut_and_trim.dtos.response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Service;

import lombok.Getter;

@Getter
public class BarberShopResponseServiceList {

    private UUID id;

    private String name;

    private List<Service> services = new ArrayList<Service>();

    public BarberShopResponseServiceList(BarberShop barberShop) {
        this.id = barberShop.getId();
        this.name = barberShop.getName();
        
        if (barberShop.getServices().isEmpty()) {
            this.services = null;
        } else {
            for (Service service : barberShop.getServices()) {
                this.services.add(service);
            }
        }
    }

}
