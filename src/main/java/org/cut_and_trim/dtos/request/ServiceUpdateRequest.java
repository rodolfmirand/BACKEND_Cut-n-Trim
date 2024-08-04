package org.cut_and_trim.dtos.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class ServiceUpdateRequest {

    private UUID id;
    
    private String name;

    private double price;

    private double duration;
}
