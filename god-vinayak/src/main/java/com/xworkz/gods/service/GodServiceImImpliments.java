package com.xworkz.gods.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
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
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<GodDto>> violations = validator.validate(adto);

		if (violations != null && !violations.isEmpty()) {
			System.err.println("constraintViolations exist return constraintViolations");
			return violations;
		} else
			System.out.println("constraintViolations does not exist data is good");
		GodEntity entity = new GodEntity();
		entity.setId(adto.getId());
		entity.setName(adto.getName());
		entity.setVehicle(adto.getVehicle());
		entity.setCountry(adto.getCounties());
		entity.setReligion(adto.getReligion());

		boolean saved = this.repository.save(entity);

		System.out.println("Entity data is saved " + saved);
		return Collections.emptySet();
	}

	@Override
	public GodDto findByid(int id) {
		if (id > 0) {
			GodEntity aentity = this.repository.findByid(id);
			if (aentity != null) {
				GodDto dto = new GodDto();
				dto.setId(aentity.getId());
				dto.setName(aentity.getName());
				dto.setVehicle(aentity.getVehicle());
				dto.setCounties(aentity.getCountry());
				dto.setReligion(aentity.getReligion());

				return dto;
			}

		}
		return null;
	}

	@Override
	public List<GodDto> findByName(String name) {
		System.out.println("inside  searchByDepo (service) " + name);

		if (name != null && !name.isEmpty()) {
			System.out.println("name is validating and calling the repository");

			List<GodEntity> entityDTOs = this.repository.findByName(name);

			List<GodDto> noOfList = new ArrayList<GodDto>();
			for (GodEntity entityDTO : entityDTOs) {
				GodDto dto = new GodDto();
				dto.setId(entityDTO.getId());
				dto.setCounties(entityDTO.getCountry());
				dto.setName(entityDTO.getName());
				dto.setReligion(entityDTO.getReligion());
				dto.setVehicle(entityDTO.getVehicle());
				noOfList.add(dto);

			}

			System.out.println("Size of Dtos " + noOfList.size());
			System.out.println("Size of entity " + entityDTOs.size());
			return noOfList;

		} else {
			System.err.println("Depo is not Valid");
		}
		return GodService.super.findByName(name);
	}

	@Override
	public Set<ConstraintViolation<GodDto>> validateAndUpdate(GodDto adto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validation = factory.getValidator();

		Set<ConstraintViolation<GodDto>> violations = validation.validate(adto);
		if (violations != null && !violations.isEmpty()) {
			System.out.println("violation in Dto" + adto);
			return violations;

		} else {
			System.out.println("Violations are not ther in dto and can save data");
			GodEntity entity = new GodEntity();
			// BeanUtils.copyProperties(adto, entity);
			entity.setId(adto.getId());
			entity.setName(adto.getName());
			entity.setVehicle(adto.getVehicle());
			entity.setCountry(adto.getCounties());
			entity.setReligion(adto.getReligion());

			boolean saved = this.repository.update(entity);

			System.out.println("Entity data is update " + saved);
			return Collections.emptySet();
		}

	}
	@Override
	public boolean onDelete(int id) {
		boolean deleted=repository.onDelete(id);
		
		return deleted;
		
		
	}
}
