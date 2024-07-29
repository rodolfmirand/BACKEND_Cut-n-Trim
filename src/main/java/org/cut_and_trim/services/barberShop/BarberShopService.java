package org.cut_and_trim.services.barberShop;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.response.BarberShopResponse;

public interface BarberShopService {
    
    BarberShopResponse register(BarberShopRequest barberShopRequest);

}
