package com.psps.petclinic.services;

import com.psps.petclinic.model.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);


}
