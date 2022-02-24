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

import com.poslovna.Poslovna.domain.GrupaRobe;
import com.poslovna.Poslovna.domain.Pdv;
import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.dto.GrupaRobeDTO;
import com.poslovna.Poslovna.mapper.GrupaRobeDTOToGrupaRobe;
import com.poslovna.Poslovna.mapper.GrupaRobeToGrupaRobeDTO;
import com.poslovna.Poslovna.mapper.PdvToPdvDTO;
import com.poslovna.Poslovna.mapper.PreduzeceToPreduzeceDTO;
import com.poslovna.Poslovna.service.IGrupaRobeService;
import com.poslovna.Poslovna.service.IPdvService;
import com.poslovna.Poslovna.service.IPreduzeceService;


@Controller
public class GrupaRobeController {
	
	@Autowired 
	private IGrupaRobeService grupaRobeService;
	
	@Autowired
	private IPdvService pdvService;
	
	@Autowired
	private IPreduzeceService preduzeceService;
	
	@Autowired
	private GrupaRobeToGrupaRobeDTO grupaRobeToGrupaRobeDTO;
	
	@Autowired
	private GrupaRobeDTOToGrupaRobe grupaRobeDTOToGrupaRobe;
	
	@Autowired 
	private PreduzeceToPreduzeceDTO preduzeceToPreduzeceDTO;
	
	@Autowired 
	private PdvToPdvDTO pdvToPdvDTO;;
	
	
	@GetMapping("/grupaRobe")
	public String vratiSveGrupeRobe(Model model) {
		List<GrupaRobe> grupaRobeLista = grupaRobeService.findAll();
		List<GrupaRobeDTO> listaGrupaRobeDTO = grupaRobeToGrupaRobeDTO.konvertujEntityToDto(grupaRobeLista);
		model.addAttribute("listaGrupaRobe", listaGrupaRobeDTO);
		return "grupaRobe";
	}
	
	@GetMapping("/grupaRobe/azuriraj/{id}")
	public String vratiGrupuRobeById(Model model, @PathVariable Long id) {
		GrupaRobe grupaRobe = grupaRobeService.findOne(id);
		GrupaRobeDTO grupaRobeDTO = grupaRobeToGrupaRobeDTO.konvertujEntityToDto(grupaRobe);
		dodajAtributeUModel(model, grupaRobeDTO);
		return "azurirajGrupuRobe";
	}
	
	@PutMapping("/grupaRobe/azuriraj")
	public String azurirajGrupuRobe(GrupaRobeDTO grupaRobeDTO) {
		grupaRobeService.save(grupaRobeDTOToGrupaRobe.konvertujDtoToEntity(grupaRobeDTO));
		return "redirect:/grupaRobe";
	}
	
	@GetMapping("/grupaRobe/kreiraj")
	public String prikaziGrupuRobe(Model model) {
		GrupaRobeDTO grupaRobeDTO = new GrupaRobeDTO();
		dodajAtributeUModel(model, grupaRobeDTO);
		return "kreirajGrupuRobe";
	}
	
	@PostMapping("/grupaRobe/kreiraj")
	public String kreirajGrupuRobe (GrupaRobeDTO grupaRobeDTO) {
		grupaRobeService.save(grupaRobeDTOToGrupaRobe.konvertujDtoToEntity(grupaRobeDTO));
		return "redirect:/grupaRobe";
	}
	
	@DeleteMapping("/grupaRobe/izbrisi")
	public String izbrisiGrupuRobe(Long grupaRobeIdDelete) {
		GrupaRobe grupaRobe = grupaRobeService.findOne(grupaRobeIdDelete);
		grupaRobeService.izbrisiGrupuRobe(grupaRobe);
		return "redirect:/grupaRobe";
	}
	
	public void dodajAtributeUModel (Model model, GrupaRobeDTO grupaRobeDTO) {
		List<Preduzece> listaPreduzeca = preduzeceService.findAll();
		List<Pdv> listaPDV = pdvService.findAll();
		model.addAttribute("grupaRobe", grupaRobeDTO);
		model.addAttribute("listaPreduzeca", preduzeceToPreduzeceDTO.konvertujEntityToDto(listaPreduzeca));
		model.addAttribute("listaPdv", pdvToPdvDTO.konvertujEntityToDto(listaPDV));
	}

}
