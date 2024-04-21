package com.psps.petclinic.services.map;

import com.psps.petclinic.model.Owner;
import com.psps.petclinic.services.CrudService;
import com.psps.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public  class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
    @Override
    public void delete(Owner object) {
        super.delete(object);
    }
    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
