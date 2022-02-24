package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.Roba;

public interface IRobaService {

	Roba findOne(Long id);

	List<Roba> findAll();

	void save(Roba roba);

	void izbrisiRobu(Roba roba);

	void izbrisiRobuByGrupaRobeId(Long grupaRobeId);

}
