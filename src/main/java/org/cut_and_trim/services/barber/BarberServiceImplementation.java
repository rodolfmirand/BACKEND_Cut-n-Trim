package org.cut_and_trim.services.barber;

import org.cut_and_trim.dtos.request.BarberRequest;
import org.cut_and_trim.dtos.response.BarberResponse;
import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.repositories.BarberRepository;
import org.cut_and_trim.utils.BarberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberServiceImplementation implements BarberService {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private BarberMapper barberMapper;

    @Override
    public BarberResponse register(BarberRequest barberRequest) {
        if (barberRepository.findByLogin(barberRequest.getLogin()).isPresent()
                || barberRepository.findByEmail(barberRequest.getEmail()).isPresent())
            return null;

        Barber barber = barberMapper.toBarber(barberRequest);
        BarberShop barberShop = new BarberShop(barber, null);

        barber.setBarberShop(barberShop);

        barberRepository.save(barber);

        return barberMapper.toBarberResponse(barber);
    }

}
