package org.cut_and_trim.services.barberShop;

import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.dtos.response.AllBarberShopsResponseServicesList;
import org.cut_and_trim.dtos.response.BarberShopResponseServicesList;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.models.BarberShop;

public interface BarberShopService {

    void register(BarberShop barberShop);

    ServiceResponse addServiceInList(UUID barberShopID, ServiceRequest serviceRequest);

    List<AllBarberShopsResponseServicesList> findAllServices();

    BarberShopResponseServicesList findAllServicesActives(UUID id);

    BarberShopResponseServicesList findServices(UUID id);

}
