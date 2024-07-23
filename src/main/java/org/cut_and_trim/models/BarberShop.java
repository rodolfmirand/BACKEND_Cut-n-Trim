package org.cut_and_trim.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class BarberShop {
    
    @Id
    @OneToOne
    private Barber barber;

    @OneToMany
    private List<Client> clients;

    @Builder
    public BarberShop(Barber barber, List<Client> clients) {
        this.barber = barber;
        this.clients = clients;
    }

    @Builder
    public BarberShop(){
    }
}
