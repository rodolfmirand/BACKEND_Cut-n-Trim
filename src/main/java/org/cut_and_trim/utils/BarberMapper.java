package org.cut_and_trim.utils;

import java.util.ArrayList;
import java.util.List;

import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.response.BarberRegisterResponse;
import org.cut_and_trim.dtos.response.BarberResponse;
import org.cut_and_trim.models.Barber;
import org.springframework.stereotype.Component;

@Component
public class BarberMapper {

    public Barber toBarber(BarberRequest barberRequest) {
        return new Barber(barberRequest.getName(), barberRequest.getEmail(), barberRequest.getPassword());
    }

    public BarberResponse toBarberResponse(Barber barber) {
        return new BarberResponse(barber);
    }

    public BarberRegisterResponse toBarberRegisterResponse(Barber barber){
        return new BarberRegisterResponse(barber);
    }

    public List<BarberResponse> toBarbersList(List<Barber> barbersList){
        List<BarberResponse> barbersResponseList = new ArrayList<BarberResponse>();
        for(Barber barber : barbersList){
            barbersResponseList.add(new BarberResponse(barber));
        }
        return barbersResponseList;
    }
}
