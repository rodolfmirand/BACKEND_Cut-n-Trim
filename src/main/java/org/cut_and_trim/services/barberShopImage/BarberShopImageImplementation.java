package org.cut_and_trim.services.barberShopImage;

import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.BarberShopImage;
import org.cut_and_trim.repositories.BarberShopImageRepository;
import org.cut_and_trim.repositories.BarberShopRepository;
import org.cut_and_trim.services.barberShop.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class BarberShopImageImplementation implements BarberShopImageService{

    @Autowired
    private BarberShopImageRepository imageRepository;

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Override
    public BarberShopImage saveImage(MultipartFile file, UUID id) throws IOException {
        BarberShop barberShop = barberShopRepository.findById(id).orElse(null);
        if(barberShop == null) return null;

        BarberShopImage image = new BarberShopImage(file.getName(), file.getBytes());
        barberShop.setImage(image);
        imageRepository.save(image);
        barberShopRepository.save(barberShop);
        return image;
    }
}
