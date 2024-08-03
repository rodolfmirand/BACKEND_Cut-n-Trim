package org.cut_and_trim.services.barber;

import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberRegisterRequest;
import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.SignupRequest;
import org.cut_and_trim.dtos.response.BarberResponse;
import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.repositories.BarberRepository;
import org.cut_and_trim.repositories.BarberShopRepository;
import org.cut_and_trim.utils.BarberMapper;
import org.cut_and_trim.utils.BarberShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberServiceImplementation implements BarberService {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private BarberMapper barberMapper;

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Autowired
    private BarberShopMapper barberShopMapper;

    @Override
    public BarberResponse register(BarberRegisterRequest barberRegisterRequest) {
        BarberRequest barberRequest = barberRegisterRequest.getBarber();
        BarberShopRequest barberShopRequest = barberRegisterRequest.getBarberShop();

        if (barberRepository.findByUsername(barberRequest.getUsername()).isPresent()
                || barberRepository.findByEmail(barberRequest.getEmail()).isPresent())
            return null;

        Barber barber = barberMapper.toBarber(barberRequest);
        BarberShop barberShop = barberShopMapper.toBarberShop(barberShopRequest);

        barber.setBarberShop(barberShop);

        barberRepository.save(barber);

        barberShopRepository.save(barberShop);

        return barberMapper.toBarberResponse(barber);
    }

    @Override
    public BarberResponse findById(UUID barberID) {
        Barber barber = barberRepository.findById(barberID).orElse(null);
        if (barber == null)
            return null;
        return barberMapper.toBarberResponse(barber);
    }

    @Override
    public List<BarberResponse> findAll() {
        return barberMapper.toBarbersList(barberRepository.findAll());
    }

    @Override
    public UUID signUp(SignupRequest signupRequest) {
        
        Barber barber = barberRepository.findByEmail(signupRequest.getEmail()).orElse(null);

        if(barber == null) return null;

        if(barber.getPassword().equals(signupRequest.getPassword())) return barber.getId();

        return null;
    }
}
