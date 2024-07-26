package org.cut_and_trim.dtos.response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.cut_and_trim.models.BarberShop;
import org.cut_and_trim.models.Customer;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BarberShopResponseCustomerList {

    private UUID id;

    private String name;

    private List<String> customersList = new ArrayList<>();

    @Builder
    public BarberShopResponseCustomerList(BarberShop barberShop) {
        this.id = barberShop.getId();
        this.name = barberShop.getName();

        List<Customer> customers = barberShop.getCustomers();

        if (customers == null) {
            this.customersList = null;

        } else {
            for (Customer customer : customers) {
                this.customersList.add("[" + customer.getName() + ", " + customer.getPhoneNumber() + "]");
            }
        }
    }
}
