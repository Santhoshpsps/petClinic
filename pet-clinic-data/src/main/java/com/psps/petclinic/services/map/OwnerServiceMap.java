package com.psps.petclinic.services.map;

import com.psps.petclinic.model.Owner;
import com.psps.petclinic.services.CrudService;
import com.psps.petclinic.services.OwnerService;
import com.psps.petclinic.services.PetService;
import com.psps.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@Profile({"default","map"})
public  class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

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
        if(object !=null){
            if(object.getPets()!=null){
                object.getPets().forEach(pet->{
                    if(pet.getPetType() !=null){
                        if(pet.getPetType().getId() ==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else {
                        throw new RuntimeException("Pet Type cannot be null ");
                    }
                    if(pet.getId()==null){
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }

    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(owner -> Objects.equals(owner.getLastName(), lastName)).findFirst().orElse(null);
    }
}
