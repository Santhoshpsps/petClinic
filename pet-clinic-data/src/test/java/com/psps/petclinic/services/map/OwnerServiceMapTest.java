package com.psps.petclinic.services.map;

import com.psps.petclinic.model.Owner;
import com.psps.petclinic.services.PetService;
import com.psps.petclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long id =1L;
    final String lName = "Sandy";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(),new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(id).lastName(lName).build());
    }

    @Test
    void findById() {
       Owner owner=  ownerServiceMap.findById(id);
       assertNotNull(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(owners.size(),1);
    }

    @Test
    void deleteById() {

        ownerServiceMap.deleteById(id);

        assertEquals(0, ownerServiceMap.findAll().size());

    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(id));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
        ownerServiceMap.save(Owner.builder().id(2L).build());
        assertEquals(ownerServiceMap.findAll().size(),2);
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lName);
        assertNotNull(owner);
    }
}