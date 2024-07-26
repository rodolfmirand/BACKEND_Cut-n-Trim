package org.cut_and_trim.dtos.request;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerRequest {
    
    private String phoneNumber;

    private String name;

    private UUID barberShopID;
}
