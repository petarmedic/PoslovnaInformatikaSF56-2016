package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.StavkaNarudzbenice;

public interface IStavkaNarudzbeniceService {

	void save(StavkaNarudzbenice stavkaNarudzbenice);

	List<StavkaNarudzbenice> findAll(Long narudzbenica);

	List<StavkaNarudzbenice> findAll();

	StavkaNarudzbenice findOne(long id);

	void izbrisiStavkuNarudzbenice(StavkaNarudzbenice stavka);

}
