package com.sfg.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfg.petclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@RequestMapping({"","/","/index","/index.html"})
	public String getIndex(Model model) {
		
		model.addAttribute("owner",ownerService.findAll());
		return "/owners/index";
	}

	@RequestMapping("/find")
	public String findOwners() {
		return "/notImplemented";
	}
	
}
