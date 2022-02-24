package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.GrupaRobe;
import com.poslovna.Poslovna.repository.GrupaRobeRepository;
import com.poslovna.Poslovna.service.IGrupaRobeService;
import com.poslovna.Poslovna.service.IRobaService;

@Service
@Transactional
public class GrupaRobeService implements IGrupaRobeService {

	@Autowired
	GrupaRobeRepository grupaRobeRepository;
	
	@Autowired
	private IRobaService robaService;

	@Override
	public GrupaRobe findOne(Long id) {
		GrupaRobe grupaRobe = grupaRobeRepository.getOne(id);
		if (grupaRobe != null) {
			return grupaRobe;
		} else {
			throw new RuntimeException("Nije pronadjena grupa robe");
		}
	}

	@Override
	public List<GrupaRobe> findAll() {

		return grupaRobeRepository.findAll();
	}

	@Override
	public void save(GrupaRobe grupaRobe) {
		grupaRobeRepository.save(grupaRobe);
	}

	@Override
	public void izbrisiGrupuRobe(GrupaRobe grupaRobe) {
		grupaRobe.setObrisano(true);
		robaService.izbrisiRobuByGrupaRobeId(grupaRobe.getId());
		grupaRobeRepository.save(grupaRobe);
	}
	
	@Override
	public void izbrisiGrupuRobeByPdvId(Long pdvId) {	
		List<GrupaRobe> listaGrupeRobe = grupaRobeRepository.findByPdvId(pdvId);
		for (GrupaRobe grupaRobe : listaGrupeRobe) {
			izbrisiGrupuRobe(grupaRobe);
		}
		
	}

}
