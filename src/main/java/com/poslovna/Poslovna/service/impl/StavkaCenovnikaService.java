package com.poslovna.Poslovna.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.StavkaCenovnika;
import com.poslovna.Poslovna.repository.StavkaCenovnikaRepository;
import com.poslovna.Poslovna.service.IStavkaCenovnikaService;

@Service
@Transactional
public class StavkaCenovnikaService implements IStavkaCenovnikaService {

	@Autowired
	StavkaCenovnikaRepository stavkaCenovnikaRepository;

	@Override
	public List<StavkaCenovnika> findStavkeCenovnikaByCenovnikId(long id) {
		return stavkaCenovnikaRepository.findAll().stream()
				.filter(sc -> sc.getCenovnik().getId() == id)
				.collect(Collectors.toList());
	}

	@Override
	public void save(StavkaCenovnika stavka) {
		stavkaCenovnikaRepository.save(stavka);
		
	}

	@Override
	public List<StavkaCenovnika> findStavkeCenovnikaByRobaId(long id) {
		return stavkaCenovnikaRepository.findAll().stream()
				.filter(sc -> sc.getRoba().getId() == id)
				.collect(Collectors.toList());
	}
	
	

}
