package org.cut_and_trim.services.barber;

import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.response.BarberResponse;

public interface BarberService {
    
    BarberResponse register(BarberRequest barberRequest);

}
