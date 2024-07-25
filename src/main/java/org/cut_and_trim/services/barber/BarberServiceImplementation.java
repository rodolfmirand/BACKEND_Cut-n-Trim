package org.cut_and_trim.services.barber;

import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.response.BarberResponse;
import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.repositories.BarberRepository;
import org.cut_and_trim.repositories.BarberShopRepository;
import org.cut_and_trim.utils.BarberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberServiceImplementation implements BarberService {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Autowired
    private BarberMapper barberMapper;

    @Override
    public BarberResponse register(BarberRequest barberRequest) {
        if (barberRepository.findByUsername(barberRequest.getUsername()).isPresent()
                || barberRepository.findByEmail(barberRequest.getEmail()).isPresent())
            return null;

        Barber barber = barberMapper.toBarber(barberRequest);
        BarberShop barberShop = new BarberShop();

        barber.setBarberShop(barberShop);

        barberRepository.save(barber);
        barberShopRepository.save(barberShop);

        return barberMapper.toBarberResponse(barber);
    }

    @Override
    public BarberResponse findById(UUID barberID) {
        Barber barber = barberRepository.findById(barberID).orElse(null);
        if(barber == null) return null;
        return barberMapper.toBarberResponse(barber);
    }

    @Override
    public List<BarberResponse> findAll() {
        return barberMapper.toBarbersList(barberRepository.findAll());
    }
}
