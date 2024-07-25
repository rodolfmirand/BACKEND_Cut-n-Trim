package org.cut_and_trim.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class BarberShop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Client> clients;

    @Builder
    public BarberShop(){
    }
}
