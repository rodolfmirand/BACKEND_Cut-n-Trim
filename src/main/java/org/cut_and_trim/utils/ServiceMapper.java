package org.cut_and_trim.utils;

import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.models.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public Service toService(ServiceRequest serviceRequest) {
        return Service.builder()
                .name(serviceRequest.getName())
                .price(serviceRequest.getPrice())
                .description(serviceRequest.getDescription())
                .duration(serviceRequest.getDuration())
                .build();
    }

    public ServiceResponse toServiceResponse(Service service){
        return new ServiceResponse(service);
    }
}
