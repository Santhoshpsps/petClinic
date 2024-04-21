package com.psps.petclinic.bootstrap;

import com.psps.petclinic.model.Owner;
import com.psps.petclinic.model.Vet;
import com.psps.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService){

        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
    }
    @Override
    public void run(String... args) throws Exception {
        Owner santhosh = new Owner();
        santhosh.setFirstName("Santhosh");
        santhosh.setLastName("PSPS");
        santhosh.setId(1l);

        ownerService.save(santhosh);

        Owner harish = new Owner();
        harish.setFirstName("Harish");
        harish.setLastName("PSPH");
        harish.setId(2l);

        ownerService.save(harish);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ronnie");
        vet1.setLastName("Cutler");
        vet1.setId(1l);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jay");
        vet2.setLastName("Wheeler");
        vet2.setId(2l);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded Vets ... ");
    }
}
