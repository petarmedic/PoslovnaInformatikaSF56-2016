package com.poslovna.Poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.poslovna.Poslovna.domain.Mesto;
import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.dto.PreduzeceDTO;
import com.poslovna.Poslovna.mapper.MestoDTOToMesto;
import com.poslovna.Poslovna.mapper.MestoToMestoDTO;
import com.poslovna.Poslovna.mapper.PreduzeceDTOToPreduzece;
import com.poslovna.Poslovna.mapper.PreduzeceToPreduzeceDTO;
import com.poslovna.Poslovna.service.IMestoService;
import com.poslovna.Poslovna.service.IPreduzeceService;

@Controller
public class PreduzeceController {

	@Autowired
	IPreduzeceService preduzeceService;
	
	@Autowired
	PreduzeceDTOToPreduzece preduzeceDTOToPreduzece;
	
	@Autowired
	PreduzeceToPreduzeceDTO preduzeceToPreduzeceDTO;
		
	@Autowired
	MestoDTOToMesto mestoDTOToMesto;
	
	@Autowired
	MestoToMestoDTO mestoToMestoDTO;
	
	@Autowired
	IMestoService mestoService;
	
	@GetMapping("/")
	public String vratiPreduzeca(Model model) {
		List<Preduzece> preduzece = preduzeceService.findAll();
		List<PreduzeceDTO> preduzeceDTO = preduzeceToPreduzeceDTO.konvertujEntityToDto(preduzece);
		model.addAttribute("preduzece", preduzeceDTO);
		return "preduzece";
	}
	
	@GetMapping("/preduzece/azuriraj/{id}")
	public String vratiPreduzeca(Model model, @PathVariable Long id) {
		Preduzece preduzece = preduzeceService.findOne(id);
		PreduzeceDTO preduzeceDTO = preduzeceToPreduzeceDTO.konvertujEntityToDto(preduzece);
		List<Mesto> listaMesta = mestoService.findAll();
		model.addAttribute("listaMesta", mestoToMestoDTO.konvertujEntityToDto(listaMesta));
		model.addAttribute("preduzece", preduzeceDTO);
		return "azurirajPreduzece";
	}
	
	
	@PostMapping("/preduzece/azuriraj")
	public String azurirajPreduzece(PreduzeceDTO preduzeceDTO) {
		preduzeceService.save(preduzeceDTOToPreduzece.konvertujDtoToEntity(preduzeceDTO));
		return "redirect:/";
	}
}
