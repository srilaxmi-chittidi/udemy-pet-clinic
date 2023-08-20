package com.sfg.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.sfg.petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
	
	protected Map<Long, T> map = new HashMap<>();
	
    T findById(Long id) {
    	return map.get(id);
    }
	
	T save(T object) {
		if(object !=null ) {
			if(object.getId() != null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		}else {throw new RuntimeException("Object can not be null");
			
		}
		return object;
	}
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}

	private Long getNextId() {
		
		Long nextId = null;
		try {
			nextId = Collections.max(map.keySet())+1;			
		}catch(NoSuchElementException ne) {
			nextId = 1L;
		}
		return nextId; 
	}
}
