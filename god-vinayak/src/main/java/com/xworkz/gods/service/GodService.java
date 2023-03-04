package com.xworkz.gods.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.gods.dto.GodDto;
import com.xworkz.gods.entity.GodEntity;

public interface GodService {

	Set<ConstraintViolation<GodDto>> validateAndSave(GodDto adto);

	default GodDto findByid(int id) {
		return null;

	}

	default List<GodDto> findByName(String name) {
		return Collections.emptyList();

	}
	Set<ConstraintViolation<GodDto>> validateAndUpdate(GodDto adto);
	
	 default boolean onDelete(int id) {
		return false;
		
	}
}
