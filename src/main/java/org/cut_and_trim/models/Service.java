package org.cut_and_trim.models;

import java.util.UUID;

import org.cut_and_trim.models.enums.ServiceStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "duration")
    private double duration;

    @Column(name = "status")
    private ServiceStatus status;

    public void setStatusToInactive(){
        this.status = ServiceStatus.INACTIVE;
    }

    public void  setStatusToActive(){
        this.status = ServiceStatus.ACTIVE;
    }

    public Service(String name, double price, double duration) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.status = ServiceStatus.ACTIVE;
    }

    public Service() {

    }
}
