package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.Pdv;
import com.poslovna.Poslovna.repository.PdvRepository;
import com.poslovna.Poslovna.service.IPdvService;

@Service
@Transactional(readOnly = true)
public class PdvService implements IPdvService {

	@Autowired
	PdvRepository pdvRepository;
	
	@Override
	public Pdv findOne(Long id) {
		Pdv pdv = pdvRepository.getOne(id);
		if(pdv != null) {
			return pdv;
		}
		else {
			throw new RuntimeException("Nije pronadjen pdv");
		}
	}

	@Override
	public List<Pdv> findAll() {

		return pdvRepository.findAll();
	}

}
