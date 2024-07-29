package org.cut_and_trim.services.service;

import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.models.Service;
import org.cut_and_trim.repositories.ServiceRepository;
import org.cut_and_trim.utils.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
    
}
