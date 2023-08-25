package com.sfg.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.services.OwnerService;
import com.sfg.petclinic.services.PetService;
import com.sfg.petclinic.services.PetTypeService;

@Service
public class OwnerServiceMap  extends AbstractMapService<Owner, Long> 
							 implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;
	 
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
	        this.petTypeService = petTypeService;
	        this.petService = petService;
	}
	@Override
	public Owner save(Owner object) {
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet-> {
						if(pet.getPetType() != null){
							if(pet.getPetType().getId() != null) {
								pet.setPetType(petTypeService.save(pet.getPetType()));
							}
						}
				});
			}
			return super.save(object);
		}else {
			return null;
		}
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	public Owner findByLastName(String lastName) {
		return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
	}
	
	

	
}
