package org.cut_and_trim.dtos.request;

import lombok.Getter;

import java.util.UUID;

@Getter
public class IdRequest {

    private UUID id;

    public IdRequest(UUID id){
        this.id = id;
    }
}
