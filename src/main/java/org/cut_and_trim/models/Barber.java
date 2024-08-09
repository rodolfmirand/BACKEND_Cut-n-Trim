package org.cut_and_trim.models;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.cut_and_trim.dtos.request.BarberRequest;

@Data
@Entity
@Table(name = "barbers")
public class Barber {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public Barber(String name, String phoneNumber, String email, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Barber(BarberRequest barberRequest) {
        this.name = barberRequest.getName();
        this.phoneNumber = barberRequest.getPhoneNumber();
        this.email = barberRequest.getEmail();
        this.password = barberRequest.getPassword();

    }

    public Barber() {
    }
}
