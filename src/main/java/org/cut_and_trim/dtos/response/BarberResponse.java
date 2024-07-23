package org.cut_and_trim.dtos.response;

import java.util.UUID;

import org.cut_and_trim.models.BarberShop;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BarberResponse {

    private UUID id;
    
    private String name;

    private String login;

    private String email;

    private String password;

    private BarberShop barberShop;

}
