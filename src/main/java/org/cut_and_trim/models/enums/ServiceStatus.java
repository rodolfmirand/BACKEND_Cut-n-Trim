package org.cut_and_trim.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceStatus {

    ACTIVE("A", "ACTIVE"),
    INACTIVE("I", "INACTIVE");

    private String code;
    private String description;

    private ServiceStatus(String code, String description){
        this.code = code;
        this.description = description;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public static ServiceStatus readCode(String code) {
        if (code.equals("A")) {
            return ACTIVE;
        } else if (code.equals("I")) {
            return INACTIVE;
        } else {
            return null;
        }
    }
}
