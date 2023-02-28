package com.xworkz.gods.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.gods.dto.GodDto;

public interface GodService {

	Set<ConstraintViolation<GodDto>> validateAndSave(GodDto adto);
	 default GodDto  findByid(int id) {
			return null;
			 
		 }
}
