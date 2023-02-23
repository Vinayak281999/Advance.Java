package controller;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.EggDTO;
import service.EggService;

@Controller
@RequestMapping("/egg")
public class EggController{

	@Autowired
	private EggService eggService;

	public EggController() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onOrder(EggDTO dto, Model model) {
		System.out.println("Running onOrder in Controller"+dto);
		boolean saved = this.eggService.validateAndSave(dto);
		System.out.println("Saved : "+saved);
		return "index";

	}

}
