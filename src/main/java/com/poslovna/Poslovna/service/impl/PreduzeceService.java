package com.poslovna.Poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.repository.PreduzeceRepository;
import com.poslovna.Poslovna.service.IPreduzeceService;


@Service
@Transactional
public class PreduzeceService implements IPreduzeceService {

	
	
	@Autowired
	PreduzeceRepository preduzeceRepository;
	
	@Override
	public List<Preduzece> findAll() {
		return preduzeceRepository.findAll();
	}
	
	
}
