package org.cut_and_trim.dtos.response;

import java.util.UUID;

import lombok.Getter;

@Getter
public class SignupResponse {
    
    private UUID barberID;
    
    public SignupResponse(UUID id){
        this.barberID = id;
    }
}
