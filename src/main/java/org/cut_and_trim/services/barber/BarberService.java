package org.cut_and_trim.services.barber;

import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberRegisterRequest;
import org.cut_and_trim.dtos.response.BarberRegisterResponse;
import org.cut_and_trim.dtos.response.BarberResponse;

public interface BarberService {

    BarberRegisterResponse register(BarberRegisterRequest barberRegisterRequest);

    List<BarberResponse> findAll();

    BarberResponse findById(UUID barberID);

}
