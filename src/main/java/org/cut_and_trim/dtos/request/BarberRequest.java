package org.cut_and_trim.dtos.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BarberRequest {
    
    private String name;

    private String username;

    private String email;

    private String password;

    @Builder
    public BarberRequest(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
