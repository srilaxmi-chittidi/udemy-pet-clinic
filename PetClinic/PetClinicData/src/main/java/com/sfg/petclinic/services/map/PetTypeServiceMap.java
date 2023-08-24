package com.sfg.petclinic.services.map;

import java.util.Set;

import com.sfg.petclinic.model.PetType;
import com.sfg.petclinic.services.PetTypeService;

public class PetTypeServiceMap extends AbstractMapService<PetType, Long> 
								implements PetTypeService {

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public PetType save(PetType t) {
		return super.save(t);
	}

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(PetType object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
