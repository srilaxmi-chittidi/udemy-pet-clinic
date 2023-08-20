package com.sfg.petclinic.model.bootstraper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.model.Vet;
import com.sfg.petclinic.services.OwnerService;
import com.sfg.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService,VetService vetService) {
		this.ownerService = ownerService;
		this.vetService   = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		
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
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Ram");
		vet2.setLastName("chu");
		
		vetService.save(vet2);
		System.out.println("Loaded vets....");
		
	}

}
