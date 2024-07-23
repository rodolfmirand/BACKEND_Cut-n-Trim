package org.cut_and_trim.models;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Cliente {

    private String phoneNumber;

    private String nome;

    @Builder
    public Cliente(String phoneNumber, String nome) {
        this.phoneNumber = phoneNumber;
        this.nome = nome;
    }
}
