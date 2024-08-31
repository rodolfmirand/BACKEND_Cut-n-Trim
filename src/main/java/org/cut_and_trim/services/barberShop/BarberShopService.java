package org.cut_and_trim.services.barberShop;

import java.net.MalformedURLException;
import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.response.AllBarberShopsResponseServicesList;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.dtos.response.BarberShopResponseServicesList;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.models.BarberShop;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface BarberShopService {

    List<BarberShopResponse> findAll();

    void register(BarberShop barberShop);

    ServiceResponse addServiceInList(UUID barberShopID, ServiceRequest serviceRequest);

    List<AllBarberShopsResponseServicesList> findAllServices();

    BarberShopResponseServicesList findAllServicesActives(UUID id);

    BarberShopResponseServicesList findServices(UUID id);

    boolean uploadImage(UUID id, MultipartFile image);

    Resource getImage(UUID id) throws MalformedURLException;

}
