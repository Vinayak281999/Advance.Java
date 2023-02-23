package com.xworkz.valentine.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.valentine.dto.ValentineDTO;

public interface ValentineService {
	public Set<ConstraintViolation<ValentineDTO>> validateAndSave(ValentineDTO dto);

	}

