package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.PoslovnaGodina;
import com.poslovna.Poslovna.repository.PoslovnaGodinaRepository;
import com.poslovna.Poslovna.service.IPoslovnaGodinaService;

@Service
@Transactional(readOnly = true)
public class PoslovnaGodinaService implements IPoslovnaGodinaService {
	
	@Autowired
	PoslovnaGodinaRepository poslovnaGodinaRepository;
	
	@Override
	public List<PoslovnaGodina> findAll() {
		return poslovnaGodinaRepository.findAll();
	}

	@Override
	public PoslovnaGodina getOne(long id) {
		return poslovnaGodinaRepository.getOne(id);
	}

	@Override
	public List<PoslovnaGodina> findByZakljucenaGodinaIsFalseAndObrisanoIsFalse() {
		return poslovnaGodinaRepository.findByZakljucenaGodinaIsFalseAndObrisanoIsFalse();
	}

}
