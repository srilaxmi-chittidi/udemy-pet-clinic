package com.sfg.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> 
							 implements OwnerService {

	@Override
	public Owner save(Owner object) {
		return super.save(object);
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
