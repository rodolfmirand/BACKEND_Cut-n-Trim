package org.cut_and_trim.dtos.response;

import java.util.UUID;

import org.cut_and_trim.models.Service;

import lombok.Getter;

@Getter
public class ServiceResponse {
    
    private UUID id;

    private String name;

    private double price;

    private double duration;

    private String status;

    public ServiceResponse(Service service){
        this.id = service.getId();
        this.name = service.getName();
        this.price = service.getPrice();
        this.duration = service.getDuration();
        this.status = service.getStatus().getCode();
    }
}
