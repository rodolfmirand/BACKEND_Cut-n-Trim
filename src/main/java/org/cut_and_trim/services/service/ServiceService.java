package org.cut_and_trim.services.service;

import java.util.UUID;

import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.request.ServiceUpdateRequest;
import org.cut_and_trim.dtos.response.ServiceResponse;

public interface ServiceService {
    
    ServiceResponse register(ServiceRequest serviceRequest);

    ServiceResponse update(ServiceUpdateRequest serviceRequest);

    boolean delete(UUID id);
}
