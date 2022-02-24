package com.poslovna.Poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poslovna.Poslovna.domain.Cenovnik;
import com.poslovna.Poslovna.domain.Roba;
import com.poslovna.Poslovna.domain.StavkaCenovnika;
import com.poslovna.Poslovna.service.ICenovnikService;
import com.poslovna.Poslovna.service.IRobaService;
import com.poslovna.Poslovna.service.IStavkaCenovnikaService;

@Controller
public class StavkeCenovnikaController {
	
	@Autowired
	IRobaService robaService;
	
	@Autowired
	ICenovnikService cenovnikService;
	
	@Autowired
	IStavkaCenovnikaService stavkaCenovnikaService;
	
	@GetMapping("/stavkeCenovnika")
	public void sacuvajStavkuNarudzbenice(@RequestParam(value = "cenovnikId") long cenovnikId,@RequestParam(value = "cena") int cena,@RequestParam(value = "robaId") long robaId) {	
		
		Cenovnik cenovnik = cenovnikService.findOne(cenovnikId);
		Roba roba = robaService.findOne(robaId);
		
		StavkaCenovnika stavka = new StavkaCenovnika();
		stavka.setCena(cena);
		stavka.setCenovnik(cenovnik);
		stavka.setRoba(roba);
		stavka.setObrisano(false);
		stavkaCenovnikaService.save(stavka);		
	} 

}
