package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.StavkaFakture;
import com.poslovna.Poslovna.repository.StavkaFaktureRepository;
import com.poslovna.Poslovna.service.IStavkeFaktureService;

@Service
@Transactional
public class StavkeFaktureService implements IStavkeFaktureService {

	@Autowired
	StavkaFaktureRepository stavkaFaktureRepository;
	
	@Override
	public void save(StavkaFakture novaStavkaFakture) {
		stavkaFaktureRepository.save(novaStavkaFakture);
		
	}

	@Override
	public List<StavkaFakture> findAll() {
		return stavkaFaktureRepository.findAll();
	}
	
}
