package com.poslovna.Poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poslovna.Poslovna.domain.Narudzbenica;
import com.poslovna.Poslovna.domain.Roba;
import com.poslovna.Poslovna.domain.StavkaNarudzbenice;
import com.poslovna.Poslovna.dto.StavkaNarudzbeniceDTO;
import com.poslovna.Poslovna.mapper.StavkaNarudzbeniceDTOToStavkaNarudzbenice;
import com.poslovna.Poslovna.mapper.StavkaNarudzbeniceToStavkaNarudzbeniceDTO;
import com.poslovna.Poslovna.service.INarudzbenicaService;
import com.poslovna.Poslovna.service.IRobaService;
import com.poslovna.Poslovna.service.IStavkaNarudzbeniceService;

@Controller
public class StavkaNarudzbeniceController {
	
	@Autowired
	IStavkaNarudzbeniceService stavkaNarudzbeniceService;
	
	@Autowired
	IRobaService robaService;
	
	@Autowired
	INarudzbenicaService narudzbenicaService;
	
	@Autowired
	StavkaNarudzbeniceDTOToStavkaNarudzbenice stavkaNarudzbeniceDTOToStavkaNarudzbenice;
	
	@Autowired
	StavkaNarudzbeniceToStavkaNarudzbeniceDTO stavkaNarudzbeniceToStavkaNarudzbeniceDTO;
	
	@PostMapping("/stavkaNarudzbenice")
	public void sacuvajStavkuNarudzbenice(@RequestBody StavkaNarudzbeniceDTO stavkaNarudzbenice) {
		//StavkaNarudzbenice stavka = stavkaNarudzbeniceDTOToStavkaNarudzbenice.konvertujDtoToEntity(dto);
		Roba roba = robaService.findOne(stavkaNarudzbenice.getRoba());
		Narudzbenica narudzbenica = narudzbenicaService.getOne(stavkaNarudzbenice.getNarudzbenica());
		StavkaNarudzbenice stavka = new StavkaNarudzbenice();
		stavka.setJedinicaMere(stavkaNarudzbenice.getJedinicaMere());
		stavka.setKolicina(stavkaNarudzbenice.getKolicina());
		stavka.setOpis(stavkaNarudzbenice.getOpis());
		stavka.setRoba(roba);
		stavka.setNarudzbenica(narudzbenica);
		stavka.setObrisano(false);
		
		stavkaNarudzbeniceService.save(stavka);
	}
	
	@GetMapping("/stavkaNarudzbenice/obrisi/{id}/{narudzbenicaId}")
	public String izbrisiStavkuNarudzbenice(@PathVariable long id, @PathVariable long narudzbenicaId) {
		StavkaNarudzbenice stavka = stavkaNarudzbeniceService.findOne(id);
		stavkaNarudzbeniceService.izbrisiStavkuNarudzbenice(stavka);
		return "redirect:/narudzbenica/detalji/{narudzbenicaId}";
	}

}
