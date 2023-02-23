package com.xworkz.aeroplan.repository;

import com.xworkz.aeroplan.entity.AeroEntity;


public interface AeroRepositery {

	boolean save(AeroEntity aentity);
	
	default AeroEntity findByid(int id) {
		return null;
	}
}
