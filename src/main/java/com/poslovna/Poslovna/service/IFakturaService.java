package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.Faktura;

public interface IFakturaService {

	Faktura getOne(long idFakture);

	List<Faktura> findAll();

	void save(Faktura faktura);

	void update(Faktura faktura);

}
