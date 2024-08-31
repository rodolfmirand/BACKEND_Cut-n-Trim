package org.cut_and_trim.services.barberShop;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.cut_and_trim.dtos.request.BarberShopRequest;
import org.cut_and_trim.dtos.request.ServiceRequest;
import org.cut_and_trim.dtos.response.BarberShopResponse;
import org.cut_and_trim.dtos.response.AllBarberShopsResponseServicesList;
import org.cut_and_trim.dtos.response.BarberShopResponseServicesList;
import org.cut_and_trim.dtos.response.ServiceResponse;
import org.cut_and_trim.models.Barber;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Service;
import org.cut_and_trim.models.enums.ServiceStatus;
import org.cut_and_trim.repositories.BarberRepository;
import org.cut_and_trim.repositories.BarberShopRepository;
import org.cut_and_trim.repositories.ServiceRepository;
import org.cut_and_trim.utils.BarberShopMapper;
import org.cut_and_trim.utils.ServiceMapper;
import org.cut_and_trim.utils.UploadImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Service
public class BarberShopServiceImplementation implements BarberShopService {

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Autowired
    private BarberShopMapper barberShopMapper;

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    @Autowired
    private UploadImageUtil uploadImageUtil;

    @Override
    public List<BarberShopResponse> findAll() {
        return barberShopMapper.toBarberShopsResponse(barberShopRepository.findAll());
    }

    @Override
    public BarberShopResponse findById(UUID id) {
        return barberShopMapper.toBarberShopResponse(barberShopRepository.findById(id).orElse(null));
    }

    @Override
    public void register(BarberShop barberShop) {
        barberShopRepository.save(barberShop);
    }

    @Override
    public ServiceResponse addServiceInList(UUID barberShopID, ServiceRequest serviceRequest) {
        BarberShop barberShop = barberShopRepository.findById(barberShopID).orElse(null);

        if (barberShop == null)
            return null;

        Service service = serviceMapper.toService(serviceRequest);

        barberShop.addService(service);

        serviceRepository.save(service);

        barberShopRepository.save(barberShop);

        return serviceMapper.toServiceResponse(service);
    }

    @Override
    public List<AllBarberShopsResponseServicesList> findAllServices() {
        return barberShopMapper.toAllBarberShopsServicesList(barberShopRepository.findAll());
    }

    @Override
    public BarberShopResponseServicesList findServices(UUID id) {
        return barberShopMapper.toBarberShopResponseServicesList(barberShopRepository.findById(id).orElse(null));
    }

    @Override
    public boolean uploadImage(UUID id, MultipartFile image) {
        BarberShop barberShop = barberShopRepository.findById(id).orElse(null);

        if (barberShop == null) return false;

        try {
            if (uploadImageUtil.uploadImage(image)) {
                barberShop.setImage(image.getOriginalFilename());
            }
            barberShopRepository.save(barberShop);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Resource getImage(UUID id) throws MalformedURLException {
        BarberShop barberShop = barberShopRepository.findById(id).orElse(null);
        if (barberShop == null) return null;

        Path path = Paths.get("src/main/resources/static/images/" + barberShop.getImage());
        Resource image = new UrlResource(path.toUri());

        if (image.exists() || image.isReadable()) {
            return image;
        } else {
            return null;
        }
    }

    @Override
    public BarberShopResponseServicesList findAllServicesActives(UUID id) {
        List<Service> services = new ArrayList<Service>();

        BarberShop barberShop = barberShopRepository.findById(id).orElse(null);

        if (barberShop == null)
            return null;

        for (Service sv : barberShop.getServices()) {
            if (!sv.getStatus().equals(ServiceStatus.ACTIVE))
                continue;
            services.add(sv);
        }

        return new BarberShopResponseServicesList(services);
    }
}
