package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.StopaPdv;
import com.poslovna.Poslovna.repository.StopaPdvRepository;
import com.poslovna.Poslovna.service.IStopaPdvService;

@Service
@Transactional
public class StopaPdvService implements IStopaPdvService {

	@Autowired
	StopaPdvRepository stopaPdvRepository;
	

	
	@Override
	public StopaPdv findOne(Long id) {
		StopaPdv stopaPdv = stopaPdvRepository.getOne(id);
		if(stopaPdv != null) {
			return stopaPdv;
		}
		else {
			throw new RuntimeException("Nije pronadjena stopa pdv");
		}
	}

	@Override
	public List<StopaPdv> findAll() {

		return stopaPdvRepository.findAll();
	}

	@Override
	public void save(StopaPdv stopaPDV) {
		stopaPdvRepository.save(stopaPDV);
	}

	@Override
	public void izbrisiStopuPdv(StopaPdv stopaPdv) {
		stopaPdv.setObrisano(true);
		stopaPdvRepository.save(stopaPdv);
	}

}