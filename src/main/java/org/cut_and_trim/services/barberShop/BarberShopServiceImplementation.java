package org.cut_and_trim.services.barberShop;

import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.dtos.response.BarberShopResponseServiceList;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Service;
import org.cut_and_trim.repositories.BarberRepository;
import org.cut_and_trim.repositories.BarberShopRepository;
import org.cut_and_trim.repositories.ServiceRepository;
import org.cut_and_trim.utils.BarberShopMapper;
import org.cut_and_trim.utils.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class BarberShopServiceImplementation implements BarberShopService {

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Autowired
    private BarberShopMapper barberShopMapper;

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public BarberShopResponse register(BarberShopRequest barberShopRequest) {
        Barber barber = barberRepository.findById(barberShopRequest.getBarberID()).orElse(null);

        if (barber == null)
            return null;

        BarberShop barberShop = barberShopMapper.toBarberShop(barberShopRequest);

        barber.setBarberShop(barberShop);

        barberShopRepository.save(barberShop);
        barberRepository.save(barber);

        return barberShopMapper.toBarberShopResponse(barberShop);
    }

    @Override
    public ServiceResponse addServiceInList(UUID barberShopID, UUID serviceID) {
        BarberShop barberShop = barberShopRepository.findById(barberShopID).orElse(null);

        if (barberShop == null)
            return null;

        Service service = serviceRepository.findById(serviceID).orElse(null);

        if(service == null)
            return null;

        barberShop.addServiceInList(service);

        barberShopRepository.save(barberShop);

        return serviceMapper.toServiceResponse(service);
    }

    @Override
    public List<BarberShopResponseServiceList> findAllServices() {
        return barberShopMapper.toAllBarberShopsServicesList(barberShopRepository.findAll());
    }

}
