package com.xworkz.valentine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.valentine.dto.ValentineDTO;
import com.xworkz.valentine.service.ValentineService;

@Controller
@RequestMapping("/valentine")
public class ValentineController {
	@Autowired
	private ValentineService valentineService;
	List<String> places = Arrays.asList("Cubbon park", "LalBagh", "MetroStation", "Cenema Hall", "Jayanagar",
			"VijayNagar");
	List<String> gifts = Arrays.asList("Teddy", "Chocolate", "I-Phone");

	public ValentineController() {
		System.out.println("Created " + getClass().getSimpleName());
	}

	@GetMapping
	public String onValentine(Model model) {
		System.out.println("Running onValentine Get method");
		List<String> places = Arrays.asList("Cubbon park", "LalBagh", "MetroStation", "Cenema Hall", "Jayanagar",
				"VijayNagar");
		List<String> gifts = Arrays.asList("Teddy", "Chocolate", "I-Phone");
		model.addAttribute("places", places);
		model.addAttribute("gifts", gifts);
		return "Valentine";
	}

	@PostMapping
	public String onValentine(Model model, ValentineDTO dto) {
		System.out.println("Running onValentine post method" + dto);
		Set<ConstraintViolation<ValentineDTO>> violations = valentineService.validateAndSave(dto);
		if (violations.isEmpty()) {
			System.out.println("No violations in controller go to sccess page");
			return "ValentineSucess";

		}
		model.addAttribute("places", places);
		model.addAttribute("gifts", gifts);
		model.addAttribute("errors", violations);
		model.addAttribute("dto", dto);

		return "Valentine";

	}
}