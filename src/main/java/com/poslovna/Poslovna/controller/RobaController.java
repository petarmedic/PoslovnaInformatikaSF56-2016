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
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poslovna.Poslovna.domain.GrupaRobe;
import com.poslovna.Poslovna.domain.Roba;
import com.poslovna.Poslovna.dto.RobaDTO;
import com.poslovna.Poslovna.mapper.GrupaRobeDTOToGrupaRobe;
import com.poslovna.Poslovna.mapper.GrupaRobeToGrupaRobeDTO;
import com.poslovna.Poslovna.mapper.RobaDTOToRoba;
import com.poslovna.Poslovna.mapper.RobaToRobaDTO;
import com.poslovna.Poslovna.service.IGrupaRobeService;
import com.poslovna.Poslovna.service.IRobaService;


@Controller
public class RobaController {
	
	@Autowired 
	private IRobaService robaService;
	
	@Autowired 
	private IGrupaRobeService grupaRobeService;
	

	
	@Autowired
	private RobaToRobaDTO robaToRobaDTO;
	
	@Autowired
	private RobaDTOToRoba robaDTOToRoba;
	
	@Autowired
	private GrupaRobeToGrupaRobeDTO grupaRobeToGrupaRobeDTO;
	
	@Autowired
	private GrupaRobeDTOToGrupaRobe grupaRobeDTOToGrupaRobe;
	

	
	
	@GetMapping("/roba")
	public String vratiSveProizvode(Model model) {
		List<Roba> listaRobe = robaService.findAll();
		List<RobaDTO> listaRobeDTO = robaToRobaDTO.konvertujEntityToDto(listaRobe);
		model.addAttribute("listaRobe", listaRobeDTO);
		return "roba";
	}
	
	@GetMapping("/roba/{roba}")
	@JsonIgnore
	public @ResponseBody RobaDTO getRoba(@PathVariable("roba") long id) {
		Roba roba = robaService.findOne(id);
		
			RobaDTO robaDTO= robaToRobaDTO.konvertujEntityToDto(roba);
			return robaDTO;		
    }
	

	
	@GetMapping("/roba/azuriraj/{id}")
	public String vratiRobuById(Model model, @PathVariable Long id) {
		Roba roba = robaService.findOne(id);
		RobaDTO robaDTO = robaToRobaDTO.konvertujEntityToDto(roba);
		dodajAtributeUModel(model, robaDTO);
		return "azurirajRobu";
	}
	
	@PutMapping("/roba/azuriraj")
	public String azurirajGrupuRobe(RobaDTO robaDTO) {
		robaService.save(robaDTOToRoba.konvertujDtoToEntity(robaDTO));
		return "redirect:/roba";
	}
	
	@GetMapping("/roba/kreiraj")
	public String prikaziRobu(Model model) {
		RobaDTO robaDTO = new RobaDTO();
		dodajAtributeUModel(model, robaDTO);
		return "kreirajRobu";
	}
	
	@PostMapping("/roba/kreiraj")
	public String kreirajRobu (RobaDTO robaDTO) {
		robaService.save(robaDTOToRoba.konvertujDtoToEntity(robaDTO));
		return "redirect:/roba";
	}
	
	@DeleteMapping("/roba/izbrisi")
	public String izbrisiArtikalRobe(Long robaIdDelete) {
		Roba roba = robaService.findOne(robaIdDelete);;
		robaService.izbrisiRobu(roba);
		return "redirect:/roba";
	}
	
	public void dodajAtributeUModel (Model model, RobaDTO robaDTO) {
		List<GrupaRobe> listaGrupeRobe = grupaRobeService.findAll();
		model.addAttribute("roba", robaDTO);
		model.addAttribute("listaGrupeRobe", grupaRobeToGrupaRobeDTO.konvertujEntityToDto(listaGrupeRobe));
	}


}

