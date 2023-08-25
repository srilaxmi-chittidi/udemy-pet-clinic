package com.sfg.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sfg.petclinic.model.Speciality;
import com.sfg.petclinic.model.Vet;
import com.sfg.petclinic.services.SpecialityService;
import com.sfg.petclinic.services.VetService;

@Service
public class VetServiceMap  extends AbstractMapService<Vet, Long> 
							implements VetService {

	private SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
	        this.specialityService = specialityService;
	}
	
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		
		if(object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(speciality -> {
					if(speciality.getId() == null) {
						Speciality savedSpeciality = specialityService.save(speciality);
					}});
		}
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
