package com.psps.services.map;

import com.psps.model.Owner;
import com.psps.services.CrudService;

import java.util.Set;

public  class OwnerServiceMap extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long> {
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
        return super.save(object.getId(),object);
    }
}
