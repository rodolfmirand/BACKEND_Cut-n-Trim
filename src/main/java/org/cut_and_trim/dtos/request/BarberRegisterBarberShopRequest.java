package org.cut_and_trim.dtos.request;

import lombok.Getter;

import java.util.UUID;

@Getter
public class BarberRegisterBarberShopRequest {

    private UUID barberShopID;

    private BarberRequest barber;

}
