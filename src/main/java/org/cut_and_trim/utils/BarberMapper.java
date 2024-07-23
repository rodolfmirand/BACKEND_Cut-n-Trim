package org.cut_and_trim.utils;

import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.response.BarberResponse;
import org.cut_and_trim.models.Barber;
import org.springframework.stereotype.Component;

@Component
public class BarberMapper {

    public Barber toBarber(BarberRequest barberRequest) {
        return Barber.builder()
                .name(barberRequest.getName())
                .login(barberRequest.getLogin())
                .email(barberRequest.getEmail())
                .password(barberRequest.getPassword())
                .build();
    }

    public BarberResponse toBarberResponse(Barber barber) {
        return BarberResponse.builder()
                .id(barber.getId())
                .login(barber.getLogin())
                .email(barber.getEmail())
                .password(barber.getPassword())
                .barberShop(barber.getBarberShop())
                .build();
    }
}
