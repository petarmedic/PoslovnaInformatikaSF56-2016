package com.poslovna.Poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.dto.PreduzeceDTO;
import com.poslovna.Poslovna.mapper.PreduzeceToPreduzeceDTO;
import com.poslovna.Poslovna.service.IPreduzeceService;

@Controller
public class PreduzeceController {

	@Autowired
	IPreduzeceService preduzeceService;
	
	@Autowired
	PreduzeceToPreduzeceDTO preduzeceToPreduzeceDTO;
	
	@GetMapping("/")
	public String vratiPreduzeca(Model model) {
		List<Preduzece> preduzece = preduzeceService.findAll();
		List<PreduzeceDTO> preduzeceDTO = preduzeceToPreduzeceDTO.konvertujEntityToDto(preduzece);
		model.addAttribute("preduzece", preduzeceDTO);
		return "preduzece";
	}
}
