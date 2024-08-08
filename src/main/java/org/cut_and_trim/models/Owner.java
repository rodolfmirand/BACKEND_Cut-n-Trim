package org.cut_and_trim.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.cut_and_trim.dtos.request.OwnerRequest;

import java.util.UUID;

@Data
@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne
    private BarberShop barberShop;

    public Owner(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Owner(OwnerRequest ownerRequest){
        this.name = ownerRequest.getName();
        this.email = ownerRequest.getEmail();
        this.password = ownerRequest.getPassword();
    }

    public Owner() {
    }
}
