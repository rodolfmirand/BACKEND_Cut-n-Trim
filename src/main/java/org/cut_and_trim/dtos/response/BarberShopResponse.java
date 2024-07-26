package org.cut_and_trim.dtos.response;

import java.util.UUID;

import org.cut_and_trim.models.BarberShop;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BarberShopResponse {
    
    private UUID id;

    private String name;
    
    @Builder
    public BarberShopResponse(BarberShop barberShop){
        this.id = barberShop.getId();
        this.name = barberShop.getName();
    }

}
