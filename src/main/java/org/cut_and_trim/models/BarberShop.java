package org.cut_and_trim.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class BarberShop {
    
    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Barber barber;

    @OneToMany(cascade = CascadeType.ALL)
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
