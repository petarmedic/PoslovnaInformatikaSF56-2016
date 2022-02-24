package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.Cenovnik;
import com.poslovna.Poslovna.repository.CenovnikRepository;
import com.poslovna.Poslovna.service.ICenovnikService;

@Service
@Transactional
public class CenovnikService implements ICenovnikService {

	@Autowired
	CenovnikRepository cenovnikRepository;
	
	
	@Override
	public List<Cenovnik> findAll() {
		return cenovnikRepository.findAll();
	}

	@Override
	public Cenovnik findOne(long id) {
		return cenovnikRepository.getOne(id);
	}

	@Override
	public void save(Cenovnik cenovnik) {
		cenovnikRepository.save(cenovnik);
		
	}

}
