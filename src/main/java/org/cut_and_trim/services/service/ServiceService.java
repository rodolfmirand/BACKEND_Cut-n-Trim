package org.cut_and_trim.services.service;

import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.response.ServiceResponse;

public interface ServiceService {
    
    ServiceResponse register(ServiceRequest serviceRequest);
}
