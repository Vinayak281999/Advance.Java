package com.xworkz.gods.repo;


import com.xworkz.gods.entity.GodEntity;

public interface GodRepositery {

	boolean save(GodEntity gentity);
	
	default GodEntity findByid(int id) {
		return null;
}
}
