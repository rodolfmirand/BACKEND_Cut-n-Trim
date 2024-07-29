package org.cut_and_trim.services.barberShop;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.repositories.BarberRepository;
import org.cut_and_trim.repositories.BarberShopRepository;
import org.cut_and_trim.utils.BarberShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberShopServiceImplementation implements BarberShopService{

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Autowired
    private BarberShopMapper barberShopMapper;

    @Autowired
    private BarberRepository barberRepository;

    @Override
    public BarberShopResponse register(BarberShopRequest barberShopRequest) {
        Barber barber = barberRepository.findById(barberShopRequest.getBarberID()).orElse(null);

        if(barber == null)
            return null;
        
        BarberShop barberShop = barberShopMapper.toBarberShop(barberShopRequest);

        barber.setBarberShop(barberShop);

        barberShopRepository.save(barberShop);
        barberRepository.save(barber);
        
        return barberShopMapper.toBarberShopResponse(barberShop);
    }
    
}
