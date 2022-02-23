package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.Mesto;
import com.poslovna.Poslovna.repository.MestoRepository;
import com.poslovna.Poslovna.service.IMestoService;
import com.poslovna.Poslovna.service.IPoslovniPartnerService;

@Service
@Transactional
public class MestoService implements IMestoService {

	@Autowired
	MestoRepository mestoRepository;
	
	@Autowired
	IPoslovniPartnerService poslovniPartnerService;
	
	@Override
	public Mesto findOne(Long id) {
		Mesto mesto = mestoRepository.getOne(id);
		if(mesto != null) {
			return mesto;
		}
		else {
			throw new RuntimeException("Nije pronadjeno trazeno mesto");
		}
	}

	@Override
	public List<Mesto> findAll() {

		return mestoRepository.findAll();
	}

	@Override
	public void save(Mesto mesto) {
		mestoRepository.save(mesto);
		
	}

	@Override
	public void izbrisiMesto(Mesto mesto) {
		mesto.setObrisano(true);
		poslovniPartnerService.izbrisiPoslovnogPartneraByMestoId(mesto.getId());
		mestoRepository.save(mesto);
	}

}
