package org.cut_and_trim.dtos.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class ServiceDeleteRequest {
    
    private UUID barberShopID;

    private UUID serviceID;
}
