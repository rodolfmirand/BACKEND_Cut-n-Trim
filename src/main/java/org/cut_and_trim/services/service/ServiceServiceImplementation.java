package org.cut_and_trim.services.service;

import java.util.UUID;

import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.request.ServiceUpdateRequest;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.models.Service;
import org.cut_and_trim.repositories.ServiceRepository;
import org.cut_and_trim.utils.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceServiceImplementation implements ServiceService{

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceMapper serviceMapper;

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

        serviceRepository.save(service);
        
        return serviceMapper.toServiceResponse(service);
    }

    @Override
    public boolean delete(UUID id) {
        if(serviceRepository.findById(id).isEmpty()) return false;

        serviceRepository.deleteById(id);

        return true;
    }
    
}
