package com.xworkz.gods.controller;


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


import com.xworkz.gods.dto.GodDto;
import com.xworkz.gods.service.GodService;

@Controller
@RequestMapping("/")
public class GodController {

	@Autowired
	private GodService godService;
	
	public GodController() {
	
		System.out.println("Created " + getClass().getSimpleName());
	}
	
	List<String> religion = Arrays.asList( "Hindu", "Muslim");
	List<String> counties = Arrays.asList("India", "UAE");
	
	@GetMapping("/aero")
	public String getRegister(Model model) {
		System.out.println("Running in getMapping");
		model.addAttribute("religion", religion);
		model.addAttribute("country", counties);
		return "godName";

	}
	@PostMapping("/aero")
	public String  onGodShow( Model model,GodDto adto) {
	
		Set<ConstraintViolation<GodDto>> violations = godService.validateAndSave(adto);
		if (violations.isEmpty()) {
			System.out.println("No violations in controller go to sccess page");
			
			model.addAttribute("message", "Data is  Save");
			model.addAttribute("religion", religion);
			model.addAttribute("country", counties);
		
			return "success";
		}
		model.addAttribute("religion", religion);
		model.addAttribute("country", counties);
		model.addAttribute("errors", violations);
		model.addAttribute("message", "Data is not Save");
		return "godName";
		
	}
	@GetMapping("/Search")
	public String getSearch(Model model,@RequestParam int id) {
		GodDto adto= this.godService.findByid(id);
		if (adto!=null) {
			model.addAttribute("dto", adto);	
			
		} else {

			model.addAttribute("message", " Data is not Save");
		}
		
		return "search";
		
	}
}
