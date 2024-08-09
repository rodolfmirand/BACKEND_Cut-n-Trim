package org.cut_and_trim.dtos.response;

import java.util.UUID;

import lombok.Getter;

@Getter
public class SignupResponse {
    
    private UUID id;
    
    public SignupResponse(UUID id){
        this.id = id;
    }
}
