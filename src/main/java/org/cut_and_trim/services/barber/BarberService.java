package org.cut_and_trim.services.barber;

import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.response.BarberResponse;

public interface BarberService {

    BarberResponse register(BarberRequest barberRequest);

    List<BarberResponse> findAll();

    BarberResponse findById(UUID barberID);

}
