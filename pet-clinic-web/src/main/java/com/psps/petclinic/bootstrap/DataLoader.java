package com.psps.petclinic.bootstrap;

import com.psps.petclinic.model.Owner;
import com.psps.petclinic.model.Pet;
import com.psps.petclinic.model.PetType;
import com.psps.petclinic.model.Vet;
import com.psps.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService, PetTypeService petTypeService){

        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("DOGGY");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("PUSSY");
        PetType savedCat = petTypeService.save(cat);



        Owner santhosh = new Owner();
        santhosh.setFirstName("Santhosh");
        santhosh.setLastName("PSPS");
        santhosh.setId(1l);
        santhosh.setCity("VNR");
        santhosh.setTelephone("+91-24323253252");
        santhosh.setAddress("32, PSP Street,VNR");

        ownerService.save(santhosh);

        Pet pet1 = new Pet();
        pet1.setName("Bommy");
        pet1.setPetType(dog);
        pet1.setOwner(santhosh);
        pet1.setBirthDate(LocalDate.now());
        santhosh.getPets().add(pet1);

        Owner harish = new Owner();
        harish.setFirstName("Harish");
        harish.setLastName("PSPH");
        harish.setId(2l);
        harish.setAddress("41,Rm Street, Mexico");
        harish.setCity("DOM");
        harish.setTelephone("+1-023345324");

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
