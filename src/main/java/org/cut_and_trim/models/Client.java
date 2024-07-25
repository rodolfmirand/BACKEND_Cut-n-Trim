package org.cut_and_trim.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Client {

    @Id
    private String phoneNumber;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "barber_shop_id")
    private BarberShop barberShop;

    @Builder
    public Client(String phoneNumber, String nome) {
        this.phoneNumber = phoneNumber;
        this.nome = nome;
    }
}
