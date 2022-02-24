package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.StavkaOtpremnice;
import com.poslovna.Poslovna.repository.StavkaOtpremniceRepository;
import com.poslovna.Poslovna.service.IStavkaOtpremniceService;

@Service
@Transactional
public class StavkaOtpremniceService implements IStavkaOtpremniceService {
	
	@Autowired
	StavkaOtpremniceRepository stavkaOtpremniceRepository;

	@Override
	public List<StavkaOtpremnice> findAll() {
		return stavkaOtpremniceRepository.findAllOtpremnice();
	}

	@Override
	public void save(StavkaOtpremnice stavka) {
        stavkaOtpremniceRepository.save(stavka);		
	}

	@Override
	public StavkaOtpremnice findOne(long id) {
		return stavkaOtpremniceRepository.getOne(id);
	}

	@Override
	public void izbrisiStavkuOtpremnice(StavkaOtpremnice stavka) {
		stavka.setObrisano(true);
		stavkaOtpremniceRepository.save(stavka);
		
	}


}
