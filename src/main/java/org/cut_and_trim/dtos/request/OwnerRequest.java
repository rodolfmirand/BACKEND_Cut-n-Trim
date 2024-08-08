package org.cut_and_trim.dtos.request;

import lombok.Getter;

@Getter
public class OwnerRequest {

    private String name;

    private String email;

    private String password;

    public OwnerRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
