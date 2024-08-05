package org.cut_and_trim.utils;

import java.util.ArrayList;
import java.util.List;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.dtos.response.AllBarberShopsResponseServicesList;
import org.cut_and_trim.dtos.response.BarberShopResponseServicesList;
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

    public AllBarberShopsResponseServicesList toBarberShopResponseServiceList(BarberShop barberShop){
        return new AllBarberShopsResponseServicesList(barberShop);
    }

    public List<AllBarberShopsResponseServicesList> toAllBarberShopsServicesList(List<BarberShop> barberShops){
        List<AllBarberShopsResponseServicesList> barberShopsList = new ArrayList<AllBarberShopsResponseServicesList>();

        for(BarberShop barberShop : barberShops){
            barberShopsList.add(toBarberShopResponseServiceList(barberShop));
        }
        
        return barberShopsList;
    }

    public BarberShopResponseServicesList toBarberShopResponseServicesList(BarberShop barberShop){
        return new BarberShopResponseServicesList(barberShop);
    }
}
