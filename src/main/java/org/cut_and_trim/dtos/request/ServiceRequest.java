package org.cut_and_trim.dtos.request;

import lombok.Getter;

@Getter
public class ServiceRequest {
    
    private String name;

    private double price;

    private String description;

    private double duration;
}
