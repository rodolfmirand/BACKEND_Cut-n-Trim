package org.cut_and_trim.dtos.request;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
public class SchedulingCreateRequest {

    private UUID barberShopId;

    private String customerPhone;

    private UUID serviceId;

    private LocalTime hourly;

    private LocalDate date;

    public SchedulingCreateRequest(UUID barberShopId, String customerId, UUID serviceId, LocalTime hourly, LocalDate date) {
        this.barberShopId = barberShopId;
        this.customerPhone = customerId;
        this.serviceId = serviceId;
        this.hourly = hourly;
        this.date = date;
    }
}
