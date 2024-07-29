package org.cut_and_trim.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private double duration;

    @Builder
    public Service(String name, double price, String description, double duration) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.duration = duration;
    }
}
