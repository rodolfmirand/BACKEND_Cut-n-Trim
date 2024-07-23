package org.cut_and_trim.models;

import java.util.UUID;

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

    private String name;

    private String login;

    private String email;

    private String password;

    @OneToOne
    private BarberShop barberShop;

    @Builder
    public Barber(String name, String login, String email, String password) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @Builder
    public Barber() {
    }
}
