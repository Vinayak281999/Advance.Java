package com.xworkz.aeroplan.controller;


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
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.aeroplan.dto.AeroplanDto;
import com.xworkz.aeroplan.service.AeroService;

@Controller
@RequestMapping("/")
public class AeroController {
	
	@Autowired
	private AeroService aeroService;
	
	public AeroController() {
		
		System.out.println("Created " + getClass().getSimpleName());
	}
	
	List<String> types = Arrays.asList( "F-22", "F-16");
	List<String> counties = Arrays.asList("India", "Russia");
	
	@GetMapping("/aero")
	public String getRegister(Model model) {
		System.out.println("Running in getMapping");
		model.addAttribute("type", types);
		model.addAttribute("country", counties);
		return "Register";

	}
	@PostMapping("/aero")
	public String onAirShow( Model model,AeroplanDto adto) {
	
		Set<ConstraintViolation<AeroplanDto>> violations = aeroService.validateAndSave(adto);
		if (violations.isEmpty()) {
			System.out.println("No violations in controller go to sccess page");
			
			model.addAttribute("message", "Data is  Save");
			model.addAttribute("type", types);
			model.addAttribute("country", counties);
		
			return "Register";
		}
		model.addAttribute("type", types);
		model.addAttribute("country", counties);
		model.addAttribute("errors", violations);
		model.addAttribute("message", "Data is not Save");
		return "Register";

	}
	@GetMapping("/Search")
	public String getSearch(Model model,@RequestParam int id) {
		
		AeroplanDto adto =this.aeroService.findByid(id);
		if (adto!=null) {
			model.addAttribute("dto", adto);
			
		} else {
			model.addAttribute("message", " Data is not Save");
		}
		return "search";
		
		
	}
}
