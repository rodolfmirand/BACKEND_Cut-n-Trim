package org.cut_and_trim.services.owner;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.OwnerRequest;
import org.cut_and_trim.dtos.response.OwnerResponse;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Owner;
import org.cut_and_trim.repositories.OwnerRepository;
import org.cut_and_trim.services.barberShop.BarberShopService;
import org.cut_and_trim.utils.BarberShopMapper;
import org.cut_and_trim.utils.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OwnerServiceImplementation implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private BarberShopService barberShopService;

    @Autowired
    private BarberShopMapper barberShopMapper;

    @Override
    public List<OwnerResponse> findAll() {
        return ownerMapper.toOwnerList(ownerRepository.findAll());
    }

    @Override
    public OwnerResponse findById(UUID id) {
        return new OwnerResponse(ownerRepository.findById(id).orElse(null));
    }

    @Override
    public OwnerResponse register(OwnerRequest ownerRequest, BarberShopRequest barberShopRequest) {
        if (ownerRepository.findByEmail(ownerRequest.getEmail()).isPresent()) return null;

        Owner owner = ownerMapper.toOwner(ownerRequest);

        barberShopRequest.setOwnerID(owner.getId());
        BarberShop barberShop = barberShopMapper.toBarberShop(barberShopRequest);

        barberShopService.register(barberShop);

        owner.setBarberShop(barberShop);
        ownerRepository.save(owner);



        return new OwnerResponse(owner);
    }
}
