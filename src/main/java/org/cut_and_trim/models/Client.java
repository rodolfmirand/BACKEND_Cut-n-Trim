package org.cut_and_trim.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Client {

    @Id
    private String phoneNumber;

    private String nome;

    @Builder
    public Client(String phoneNumber, String nome) {
        this.phoneNumber = phoneNumber;
        this.nome = nome;
    }
}
