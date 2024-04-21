package com.psps.petclinic.bootstrap;

import com.psps.petclinic.model.Owner;
import com.psps.petclinic.services.*;
import com.psps.petclinic.services.map.OwnerServiceMap;
import com.psps.petclinic.services.map.PetServiceMap;
import com.psps.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;

    public DataLoader(){
        this.ownerService = new OwnerServiceMap();
        this.petService = new PetServiceMap();
        this.vetService = new VetServiceMap();
    }
    @Override
    public void run(String... args) throws Exception {
        Owner santhosh = new Owner();
        santhosh.setFirstName("Santhosh");
        santhosh.setLastName("PSPS");
        santhosh.setId(1l);

        ownerService.save(santhosh);

        System.out.println(ownerService.findAll().size());
    }
}
