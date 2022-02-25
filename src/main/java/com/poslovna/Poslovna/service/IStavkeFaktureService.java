package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.StavkaFakture;

public interface IStavkeFaktureService {

	void save(StavkaFakture novaStavkaFakture);

	List<StavkaFakture> findAll();

}
