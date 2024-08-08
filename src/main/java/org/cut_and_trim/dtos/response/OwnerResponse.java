package org.cut_and_trim.dtos.response;

import lombok.Getter;
import org.cut_and_trim.models.Owner;

@Getter
public class OwnerResponse {

    private String name;

    private String email;

    private String password;

    private BarberShopResponse barberShop;

    public OwnerResponse(Owner owner) {
        this.name = owner.getName();
        this.email = owner.getEmail();
        this.password = owner.getPassword();
        this.barberShop = new BarberShopResponse(owner.getBarberShop());
    }
}
