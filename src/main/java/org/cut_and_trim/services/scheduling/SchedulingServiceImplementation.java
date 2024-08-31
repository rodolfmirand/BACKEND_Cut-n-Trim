package org.cut_and_trim.services.scheduling;

import org.cut_and_trim.dtos.request.SchedulingCreateRequest;
import org.cut_and_trim.dtos.request.SchedullingDeleteRequest;
import org.cut_and_trim.dtos.request.SchedullingRequest;
import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Customer;
import org.cut_and_trim.models.Scheduling;
import org.cut_and_trim.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulingServiceImplementation{

    @Autowired
    private SchedullingRepository repository;

    @Autowired
    private BarberShopRepository barberShopRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public Boolean createSchedulling(SchedulingCreateRequest request){
        try{
            BarberShop barberShop = barberShopRepository.findById(request.getBarberShopId()).orElse(null);

            Customer customer = customerRepository.findByPhoneNumber(request.getCustomerPhone()).orElse(null);

            org.cut_and_trim.models.Service service = serviceRepository.findById(request.getServiceId()).orElse(null);

            Scheduling scheduling = new Scheduling(barberShop, customer, service, request.getHourly(), request.getDate());

            repository.save(scheduling);

            return true;

        }catch (Exception e){
            return false;
        }
    }

    public List<Scheduling> getSchedulling(SchedullingRequest request){
        BarberShop barberShop = barberShopRepository.findById(request.getBarberShopId()).orElse(null);
        List<Scheduling> response = repository.findByBarberAndDate(barberShop, request.getDate()).orElse(null);
        return response;
    }

    public boolean deleteSchedulling(SchedullingDeleteRequest request){
        BarberShop barberShop = barberShopRepository.findById(request.getBarberShopId()).orElse(null);
        Optional<Scheduling> schedulingOptional = repository.findScheduling(barberShop, request.getDate(), request.getHourly());

        if (schedulingOptional.isPresent()) {
            repository.delete(schedulingOptional.get());
            return true;
        } else {
            return false;
        }
    }

}
