package org.cut_and_trim.utils;

import java.util.ArrayList;
import java.util.List;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.dtos.response.BarberShopResponseServiceList;
import org.cut_and_trim.models.BarberShop;
import org.springframework.stereotype.Component;

@Component
public class BarberShopMapper {

    public BarberShop toBarberShop(BarberShopRequest barberShopRequest) {
        return BarberShop.builder()
                .name(barberShopRequest.getName())
                .street(barberShopRequest.getStreet())
                .number(barberShopRequest.getNumber())
                .neighborhood(barberShopRequest.getNeighborhood())
                .city(barberShopRequest.getCity())
                .state(barberShopRequest.getState())
                .cep(barberShopRequest.getCep())
                .build();
    }

    public BarberShopResponse toBarberShopResponse(BarberShop barberShop) {
        return new BarberShopResponse(barberShop);
    }

    public BarberShopResponseServiceList toBarberShopResponseServiceList(BarberShop barberShop){
        return new BarberShopResponseServiceList(barberShop);
    }

    public List<BarberShopResponseServiceList> toAllBarberShopsServicesList(List<BarberShop> barberShops){
        List<BarberShopResponseServiceList> barberShopsList = new ArrayList<BarberShopResponseServiceList>();

        for(BarberShop barberShop : barberShops){
            barberShopsList.add(toBarberShopResponseServiceList(barberShop));
        }
        
        return barberShopsList;
    }
}
