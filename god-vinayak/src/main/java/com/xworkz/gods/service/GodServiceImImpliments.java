package com.xworkz.gods.service;




import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.gods.dto.GodDto;
import com.xworkz.gods.entity.GodEntity;
import com.xworkz.gods.repo.GodRepositery;


@Service
public class GodServiceImImpliments implements GodService {
	
	@Autowired
	private GodRepositery repository; 

	private GodServiceImImpliments() {
		System.out.println("Create AirShowServiceImpl ");
		
		
	}

	@Override
	public Set<ConstraintViolation<GodDto>> validateAndSave(GodDto adto) {
		ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		Set<ConstraintViolation<GodDto>> violations=validator.validate(adto);
		
		if (violations != null && !violations.isEmpty()) {
			System.err.println("constraintViolations exist return constraintViolations");
			return violations ;
		}
		else
		System.out.println("constraintViolations does not exist data is good");
		GodEntity entity=new GodEntity();
		entity.setName(adto.getName());
		entity.setVehicle(adto.getVehicle());
		entity.setCountry(adto.getCounties());
		entity.setReligion(adto.getReligion());
		boolean saved=this.repository.save(entity);
		System.out.println("Entity data is saved " + saved);
		return Collections.emptySet();
	}
		@Override
		public GodDto findByid(int id) {
			if (id>0) {
				GodEntity aentity = this.repository.findByid(id);
				if (aentity != null) {
					GodDto dto = new GodDto();
					dto.setName(aentity.getName());
					dto.setVehicle(aentity.getVehicle());
					dto.setCounties(aentity.getCountry());
					dto.setReligion(aentity.getReligion());
					
					return dto;
				}
				
			}
			return  null;
	}



}
