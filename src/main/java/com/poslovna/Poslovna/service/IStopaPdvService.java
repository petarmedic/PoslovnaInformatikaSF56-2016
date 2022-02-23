package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.StopaPdv;

public interface IStopaPdvService {

	StopaPdv findOne(Long id);

	List<StopaPdv> findAll();

	void save(StopaPdv stopaPDV);

	void izbrisiStopuPdv(StopaPdv stopaPdv);

}
