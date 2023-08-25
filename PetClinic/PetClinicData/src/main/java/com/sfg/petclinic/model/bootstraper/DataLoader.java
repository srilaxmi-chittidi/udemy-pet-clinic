package com.sfg.petclinic.model.bootstraper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.model.PetType;
import com.sfg.petclinic.model.Speciality;
import com.sfg.petclinic.model.Vet;
import com.sfg.petclinic.services.OwnerService;
import com.sfg.petclinic.services.PetTypeService;
import com.sfg.petclinic.services.SpecialityService;
import com.sfg.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	
	public DataLoader(OwnerService ownerService,VetService vetService,
												PetTypeService petTypeService,
												SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService   = vetService;
		this.petTypeService  = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		
		if(count == 0) {
			loadData();
		}
		
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		petTypeService.save(cat);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Lakshmi");
		owner1.setLastName("Sree");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Satish");
		owner2.setLastName("Babu");
		
		ownerService.save(owner2);
		System.out.println("Loaded owners...");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Machael");
		vet1.setLastName("pun");
		vet1.getSpecialities().add(savedDentistry);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Ram");
		vet2.setLastName("chu");
		vet2.getSpecialities().add(savedRadiology);

		
		vetService.save(vet2);
		System.out.println("Loaded vets....");
	}

}
