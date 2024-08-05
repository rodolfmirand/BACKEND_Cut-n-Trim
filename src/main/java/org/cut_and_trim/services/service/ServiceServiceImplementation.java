package org.cut_and_trim.services.service;

import org.cut_and_trim.dtos.request.ServiceDeleteRequest;
import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.request.ServiceUpdateRequest;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Service;
import org.cut_and_trim.models.enums.ServiceStatus;
import org.cut_and_trim.repositories.BarberShopRepository;
import org.cut_and_trim.repositories.ServiceRepository;
import org.cut_and_trim.utils.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceServiceImplementation implements ServiceService{

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Override
    public ServiceResponse register(ServiceRequest serviceRequest) {
        Service service = serviceMapper.toService(serviceRequest);

        serviceRepository.save(service);

        return serviceMapper.toServiceResponse(service);
    }

    @Override
    public ServiceResponse update(ServiceUpdateRequest serviceUpdateRequest) {
        Service service = serviceRepository.findById(serviceUpdateRequest.getId()).orElse(null);
        
        if(service == null) return null;

        service.setName(serviceUpdateRequest.getName());
        service.setDuration(serviceUpdateRequest.getDuration());
        service.setPrice(serviceUpdateRequest.getPrice());
        service.setStatus(ServiceStatus.readCode(serviceUpdateRequest.getStatus()));

        serviceRepository.save(service);
        
        return serviceMapper.toServiceResponse(service);
    }

    @Override
    public boolean delete(ServiceDeleteRequest serviceDeleteRequest) {
        Service service = serviceRepository.findById(serviceDeleteRequest.getServiceID()).orElse(null);
        if(service == null) return false;

        BarberShop barberShop = barberShopRepository.findById(serviceDeleteRequest.getBarberShopID()).orElse(null);
        if(barberShop == null) return false;

        barberShop.removeServiceFromList(service);
        serviceRepository.delete(service);

        return true;
    }
}
