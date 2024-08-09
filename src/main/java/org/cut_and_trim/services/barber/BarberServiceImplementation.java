package org.cut_and_trim.services.barber;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberRegisterBarberShopRequest;
import org.cut_and_trim.dtos.response.BarberResponse;
import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.SignupRequest;
import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.repositories.BarberRepository;
import org.cut_and_trim.repositories.BarberShopRepository;
import org.cut_and_trim.services.barberShop.BarberShopService;
import org.cut_and_trim.utils.BarberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberServiceImplementation implements BarberService {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private BarberMapper barberMapper;

    @Autowired
    private BarberShopService barberShopService;

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Override
    public BarberResponse register(BarberRegisterBarberShopRequest barberRegisterBarberShopRequest) {

        BarberShop barberShop = barberShopRepository.findById(barberRegisterBarberShopRequest.getBarberShopID()).orElse(null);
        if (barberShop == null) return null;

        if (barberRepository.findByPhoneNumber(barberRegisterBarberShopRequest.getBarber().getPhoneNumber()).isPresent()
                || barberRepository.findByEmail(barberRegisterBarberShopRequest.getBarber().getEmail()).isPresent())
            return null;

        Barber barber = barberMapper.toBarber(barberRegisterBarberShopRequest.getBarber());

        barberShop.addBarber(barber);

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
    public UUID signUp(SignupRequest signupRequest) {
        Barber barber = barberRepository.findByEmail(signupRequest.getEmail()).orElse(null);
        if(barber == null) return null;

        if(barber.getPassword().equals(signupRequest.getPassword())) return barber.getId();

        return null;
    }

    @Override
    public List<BarberResponse> findAll() {
        return barberMapper.toBarbersList(barberRepository.findAll());
    }

}
