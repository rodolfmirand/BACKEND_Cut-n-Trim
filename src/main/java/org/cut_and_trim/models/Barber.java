package org.cut_and_trim.models;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Builder
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)   
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private BarberShop barberShop;

    @Builder
    public Barber(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Builder
    public Barber() {
    }
}
