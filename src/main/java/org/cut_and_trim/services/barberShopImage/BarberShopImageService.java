package org.cut_and_trim.services.barberShopImage;

import org.cut_and_trim.models.BarberShopImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface BarberShopImageService {

    BarberShopImage saveImage(MultipartFile file, UUID id) throws IOException;

}
