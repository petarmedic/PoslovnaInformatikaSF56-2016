package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.Mesto;

public interface IMestoService {

	Mesto findOne(Long id);

	List<Mesto> findAll();

	void save(Mesto mesto);

	void izbrisiMesto(Mesto mesto);

}
