package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.repository.PoslovniPartnerRepository;
import com.poslovna.Poslovna.service.IPoslovniPartnerService;

@Service
@Transactional
public class PoslovniPartnerService implements IPoslovniPartnerService {

	@Autowired
	PoslovniPartnerRepository poslovniPartnerRepository;

	@Override
	public List<PoslovniPartner> findAll() {
		return poslovniPartnerRepository.findAll();
	}

	@Override
	public PoslovniPartner findOne(Long id) {
		return poslovniPartnerRepository.getOne(id);
	}

	@Override
	public void save(PoslovniPartner poslovniPartner) {
		poslovniPartnerRepository.save(poslovniPartner);
	}
	
	@Override
	public void izbrisiPoslovnogPartnera(PoslovniPartner poslovniPartner) {	
		poslovniPartner.setObrisano(true);
		poslovniPartnerRepository.save(poslovniPartner);	
	}

	@Override
	public void izbrisiPoslovnogPartneraByMestoId(Long mestoId) {
		
		List<PoslovniPartner> listaPoslovnihPartnera = poslovniPartnerRepository.findByMestoId(mestoId);
		for (PoslovniPartner poslovniPartner : listaPoslovnihPartnera) {
			izbrisiPoslovnogPartnera(poslovniPartner);
		}
		
	}

}
