package com.xworkz.gods.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
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
			model.addAttribute("var", adto);	
			
		} else {

			model.addAttribute("message", " Data is not Save");
		}
		
		return "search";
		
	}
	@GetMapping("/findByName")
	public String onFindByName(@RequestParam String name, Model model) {

		System.out.println("Inside onSearchByDepo in controller " + name);
		List<GodDto> list = this.godService.findByName(name);
		model.addAttribute("list", list);

		return "searchByName";
	}
	@GetMapping("/update")
	public String onUpdate(@RequestParam int id, Model model) {
		System.out.println("running onUpdate"+id);
		GodDto dto=this.godService.findByid(id);
		model.addAttribute("dto", dto);
		model.addAttribute("religion", religion);
		model.addAttribute("country", counties);
	
		return "updateGod";
	}
		@PostMapping("/update")
		public String onUpdate(GodDto dto, Model model) {
			System.out.println("running onUpdate"+dto);
		Set<ConstraintViolation<GodDto>> constraintViolations=this.godService.validateAndUpdate(dto);
		
		if (constraintViolations.size()>0) {
			model.addAttribute("errors",constraintViolations);
			
		} else {
			model.addAttribute("message","God update Success.");

		}
		return "updateGod";
		
		
		}
		@GetMapping("/delete")
		public String onDelete(@RequestParam int id, Model model) {
			System.out.println("on delete Running");
			System.out.println("deleting:" +id);
			
			boolean dto=godService.onDelete(id);
			
			model.addAttribute("delete", dto);
			model.addAttribute("message", "Data deleted Succsesfully");
			
			return "searchByName";
			
		}
	}



