package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.Faktura;
import com.poslovna.Poslovna.domain.StavkaFakture;
import com.poslovna.Poslovna.repository.FakturaRepository;
import com.poslovna.Poslovna.service.IFakturaService;

@Service
public class FakturaService implements IFakturaService {
	
	@Autowired
	FakturaRepository fakturaRepository;

	@Override
	@Transactional(readOnly = false)
	public void update(Faktura faktura) {
		double ukupanPdv = 0;
		double ukupanIznos = 0;
		double iznosBezRabata = 0;
		double  rabat = 0;
		double osnovica = 0;
		for(StavkaFakture sf : faktura.getStavkeFakture()) {
			rabat += sf.getRabat();
			iznosBezRabata += sf.getKolicina() * sf.getCena();
			osnovica += sf.getOsnovicaPDV();
			ukupanPdv += sf.getIznosPDV();
			ukupanIznos += sf.getUkupanIznos();
		}
		
		faktura.setOsnovica(osnovica);
		faktura.setUkupanPdv(ukupanPdv);
		faktura.setIznosBezRabata(iznosBezRabata);
		faktura.setRabat(rabat);
		faktura.setIznosZaPlacanje(ukupanIznos);
		
		save(faktura);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void save(Faktura faktura) {
		fakturaRepository.save(faktura);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Faktura> findAll() {
		return fakturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Faktura getOne(long idFakture) {
		return fakturaRepository.getOne(idFakture);
	}


}