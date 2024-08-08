package org.cut_and_trim.services.owner;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.OwnerRequest;
import org.cut_and_trim.dtos.response.OwnerResponse;

import java.util.List;
import java.util.UUID;

public interface OwnerService {

    List<OwnerResponse> findAll();

    OwnerResponse findById(UUID id);

    OwnerResponse register(OwnerRequest ownerRequest, BarberShopRequest barberShopRequest);

}
