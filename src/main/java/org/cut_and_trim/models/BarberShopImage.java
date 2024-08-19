package org.cut_and_trim.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "barbershop_image")
public class BarberShopImage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "data")
    @Lob
    private byte[] data;

    public BarberShopImage(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
}
