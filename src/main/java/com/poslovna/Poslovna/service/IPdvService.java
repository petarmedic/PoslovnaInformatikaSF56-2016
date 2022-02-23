package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.Pdv;

public interface IPdvService {

	Pdv findOne(Long id);

	List<Pdv> findAll();

}
