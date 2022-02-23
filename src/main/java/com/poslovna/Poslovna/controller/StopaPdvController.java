package com.poslovna.Poslovna.controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.poslovna.Poslovna.domain.Pdv;
import com.poslovna.Poslovna.domain.StopaPdv;
import com.poslovna.Poslovna.dto.StopaPdvDTO;
import com.poslovna.Poslovna.mapper.PdvDTOToPdv;
import com.poslovna.Poslovna.mapper.PdvToPdvDTO;
import com.poslovna.Poslovna.mapper.StopaPdvDTOToStopaPdv;
import com.poslovna.Poslovna.mapper.StopaPdvToStopaPdvDTO;
import com.poslovna.Poslovna.service.IPdvService;
import com.poslovna.Poslovna.service.IStopaPdvService;

@Controller
public class StopaPdvController {
	
	@Autowired
	private IStopaPdvService stopaPdvService;
	
	@Autowired
	private IPdvService pdvService;
	
	@Autowired
	private StopaPdvDTOToStopaPdv stopaPdvDTOToStopaPdv;
	
	@Autowired
	private StopaPdvToStopaPdvDTO stopaPdvToStopaPdvDTO;
	
	@Autowired
	private PdvToPdvDTO pdvToPdvDTO;
	
	@Autowired
	private PdvDTOToPdv pdvDTOToPdv;
	
	
	@GetMapping("/stopaPdv")
	public String vratiStopePdv(Model model) {
		List<StopaPdv> stopaPdvLista = stopaPdvService.findAll();
		List<StopaPdvDTO> listaStopaPdvDTO = stopaPdvToStopaPdvDTO.konvertujEntityToDto(stopaPdvLista);
		model.addAttribute("listaStopaPdv", listaStopaPdvDTO);
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		model.addAttribute("dateFormat", dateFormat);
		return "stopaPdv";
	}
	
	@GetMapping("/stopaPdv/azuriraj/{id}")
	public String vratiStopuPdvById(Model model, @PathVariable Long id) {
		StopaPdv stopaPdv = stopaPdvService.findOne(id);
		StopaPdvDTO stopaPdvDTO = stopaPdvToStopaPdvDTO.konvertujEntityToDto(stopaPdv);
		List<Pdv> listaPdv = pdvService.findAll();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		model.addAttribute("dateFormat", dateFormat);
		model.addAttribute("listaPdv", pdvToPdvDTO.konvertujEntityToDto(listaPdv));
		model.addAttribute("stopaPdv", stopaPdvDTO);
		return "azurirajStopuPdv";
	}
	
	@PostMapping("/stopaPdv/azuriraj")
	public String azurirajStopuPdv(StopaPdvDTO stopaPdvDTO) {
		stopaPdvService.save(stopaPdvDTOToStopaPdv.konvertujDtoToEntity(stopaPdvDTO));
		return "redirect:/stopaPdv";
	}
	
	@GetMapping("/stopaPdv/kreiraj")
	public String prikaziStopuPdv(Model model) {
		StopaPdvDTO stopaPdvDTO = new StopaPdvDTO();
		List<Pdv> listaPdv = pdvService.findAll();
		model.addAttribute("stopaPdv", stopaPdvDTO);
		model.addAttribute("listaPdv", pdvToPdvDTO.konvertujEntityToDto(listaPdv));
		return "kreirajStopuPdv";
	}
	
	@PostMapping("/stopaPdv/kreiraj")
	public String kreirajStopuPdv(StopaPdvDTO stopaPdvDTO) throws Exception {
		List<StopaPdv> postojeceStopePDVa = stopaPdvService.findAll().stream().filter(sp -> sp.getPdv().getId() == stopaPdvDTO.getPdv().getId())
				.collect(Collectors.toList());
		for(StopaPdv stopaPDV: postojeceStopePDVa) {
			stopaPdvService.izbrisiStopuPdv(stopaPDV);
		}
		if(stopaPdvDTO.getRokVazenja().before(new Date())) {
			throw new Exception("Datum vazenja stope pdv-a mora biti u buducnosti");
		}else {
			stopaPdvService.save(stopaPdvDTOToStopaPdv.konvertujDtoToEntity(stopaPdvDTO));	
		}
		
		return "redirect:/stopaPdv";
	}
	
	@DeleteMapping("/stopaPdv/izbrisi")
	public String izbrisiStopuPdv(Long stopaPdvIdDelete) {
		StopaPdv stopaPdv = stopaPdvService.findOne(stopaPdvIdDelete);
		stopaPdvService.izbrisiStopuPdv(stopaPdv);
		return "redirect:/stopaPdv";
	}

}
