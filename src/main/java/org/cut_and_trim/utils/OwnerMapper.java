package org.cut_and_trim.utils;

import org.cut_and_trim.dtos.request.OwnerRequest;
import org.cut_and_trim.dtos.response.OwnerResponse;
import org.cut_and_trim.models.Owner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerMapper {

    public Owner toOwner(OwnerRequest ownerRequest){
        return new Owner(ownerRequest);
    }

    public List<OwnerResponse> toOwnerList(List<Owner> owners){
        List<OwnerResponse> ownersList = new ArrayList<>();

        for(Owner owner : owners){
            ownersList.add(new OwnerResponse(owner));
        }

        return ownersList;
    }
}
