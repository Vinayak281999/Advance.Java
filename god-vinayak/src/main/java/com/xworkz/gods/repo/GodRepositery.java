package com.xworkz.gods.repo;


import java.util.Collections;
import java.util.List;

import com.xworkz.gods.entity.GodEntity;



public interface GodRepositery {

	boolean save(GodEntity gentity);
	
	boolean update(GodEntity entity);
	
	default GodEntity findByid(int id) {
		return null;
}
	default List<GodEntity> findByName(String name){
		return Collections.emptyList();
		
	}

	default boolean onDelete(int id) {
		
		return false;
	}
}
