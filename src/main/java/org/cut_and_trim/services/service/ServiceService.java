package org.cut_and_trim.services.service;

import org.cut_and_trim.dtos.request.ServiceDeleteRequest;
import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.request.ServiceUpdateRequest;
import org.cut_and_trim.dtos.response.ServiceResponse;

import java.util.UUID;

public interface ServiceService {
    
    ServiceResponse register(ServiceRequest serviceRequest);

    ServiceResponse update(ServiceUpdateRequest serviceRequest);

    boolean delete(ServiceDeleteRequest serviceDeleteRequest);

    ServiceResponse findById(UUID id);
}
