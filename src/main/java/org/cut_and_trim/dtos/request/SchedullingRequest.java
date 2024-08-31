package org.cut_and_trim.dtos.request;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class SchedullingRequest {

    private UUID barberShopId;
    private LocalDate date;

    public SchedullingRequest(UUID barberShopId, LocalDate date) {
        this.barberShopId = barberShopId;
        this.date = date;
    }
}
