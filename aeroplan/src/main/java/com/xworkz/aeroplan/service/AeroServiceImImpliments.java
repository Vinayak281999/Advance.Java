package com.xworkz.aeroplan.service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.aeroplan.dto.AeroplanDto;
import com.xworkz.aeroplan.entity.AeroEntity;
import com.xworkz.aeroplan.repository.AeroRepositeryImpliments;



@Service
public class AeroServiceImImpliments implements AeroService {

	@Autowired
	private AeroRepositeryImpliments repository;
	
	
	private AeroServiceImImpliments() {
		System.out.println("Create AirShowServiceImpl ");
	}
	
	@Override
	public Set<ConstraintViolation<AeroplanDto>> validateAndSave(AeroplanDto adto) {
		ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		Set<ConstraintViolation<AeroplanDto>> violations=validator.validate(adto);
		
		if (violations != null && !violations.isEmpty()) {
			System.err.println("constraintViolations exist return constraintViolations");
			return violations ;
		
	}
		System.out.println("constraintViolations does not exist data is good");
		AeroEntity entity = new AeroEntity();
		entity.setCompany(adto.getCompany());
		entity.setCost(adto.getCost());
		entity.setCountry(adto.getCountry());
		entity.setName(adto.getName());
		entity.setType(adto.getType());
		boolean saved = this.repository.save(entity);
		System.out.println("Entity data is saved " + saved);
		return Collections.emptySet();

}
	

@Override
public AeroplanDto findByid(int id) {
	if (id > 0) {
		AeroEntity aentity = this.repository.findByid(id);
		if (aentity != null) {
			AeroplanDto dto = new AeroplanDto();
			dto.setCompany(aentity.getCompany());
			dto.setCost(aentity.getCost());
			dto.setCountry(aentity.getCountry());
			dto.setName(aentity.getName());
			dto.setType(aentity.getType());
			dto.setId(aentity.getId());
			return dto;
		}
	}
	return null;

}

}
