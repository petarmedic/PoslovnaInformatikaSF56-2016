package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.StavkaCenovnika;

public interface IStavkaCenovnikaService {

	List<StavkaCenovnika> findStavkeCenovnikaByCenovnikId(long id);

	void save(StavkaCenovnika stavka);

	List<StavkaCenovnika> findStavkeCenovnikaByRobaId(long id);

}
