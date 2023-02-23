package com.xworkz.aeroplan.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.aeroplan.dto.AeroplanDto;

public interface AeroService {
	 Set<ConstraintViolation<AeroplanDto >> validateAndSave(AeroplanDto adto);
	 
	 default AeroplanDto  findByid(int id) {
		return null;
		 
	 }
}
