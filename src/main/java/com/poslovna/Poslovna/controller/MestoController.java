package com.poslovna.Poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.poslovna.Poslovna.domain.Mesto;
import com.poslovna.Poslovna.dto.MestoDTO;
import com.poslovna.Poslovna.mapper.MestoDTOToMesto;
import com.poslovna.Poslovna.mapper.MestoToMestoDTO;
import com.poslovna.Poslovna.service.IMestoService;

@Controller
public class MestoController {
	
	@Autowired
	IMestoService mestoService;
	
	@Autowired
	MestoDTOToMesto mestoDTOToMesto;
	
	@Autowired
	MestoToMestoDTO mestoToMestoDTO;
	
	
	@GetMapping("/mesto")
	public String vratiSvaMesta(Model model) {
		List<Mesto> listaMesta = mestoService.findAll();
		List<MestoDTO> listaMestaDTO = mestoToMestoDTO.konvertujEntityToDto(listaMesta);
		model.addAttribute("listaMesta", listaMestaDTO);
		return "mesto";
	}
	
	@GetMapping("/mesto/azuriraj/{id}")
	public String vratiMesto(Model model, @PathVariable Long id) {
		Mesto mesto = mestoService.findOne(id);
		MestoDTO mestoDTO = mestoToMestoDTO.konvertujEntityToDto(mesto);
		model.addAttribute("mesto", mestoDTO);
		return "azurirajMesto";
	}
	
	@PutMapping("/mesto/azuriraj")
	public String azurirajMesto(MestoDTO mestoDTO) {
		mestoService.save(mestoDTOToMesto.konvertujDtoToEntity(mestoDTO));
		return "redirect:/mesto";
	}
	
	@GetMapping("/mesto/kreiraj")
	public String prikaziMesto(Model model) {
		Mesto mesto = new Mesto();
		MestoDTO mestoDTO = mestoToMestoDTO.konvertujEntityToDto(mesto);
		model.addAttribute("mesto", mestoDTO);
		return "kreirajMesto";
	}
	
	@PostMapping("/mesto/kreiraj")
	public String kreirajMesto(MestoDTO mestoDTO) {
		mestoService.save(mestoDTOToMesto.konvertujDtoToEntity(mestoDTO));
		return "redirect:/mesto";
	}
	
	@DeleteMapping("/mesto/izbrisi")
	public String izbrisiMesto(Long mestoIdDelete) {
		Mesto mesto = mestoService.findOne(mestoIdDelete);
		mestoService.izbrisiMesto(mesto);
		return "redirect:/mesto";
	}


}
