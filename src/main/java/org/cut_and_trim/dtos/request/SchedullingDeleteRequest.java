package org.cut_and_trim.dtos.request;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
public class SchedullingDeleteRequest {
    private UUID barberShopId;
    private LocalDate date;
    private LocalTime hourly;

    public SchedullingDeleteRequest(UUID barberShopId, LocalDate date, LocalTime hourly) {
        this.barberShopId = barberShopId;
        this.date = date;
        this.hourly = hourly;
    }
}
