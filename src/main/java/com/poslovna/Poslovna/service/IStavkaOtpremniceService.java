package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.StavkaOtpremnice;

public interface IStavkaOtpremniceService {

	List<StavkaOtpremnice> findAll();

	void save(StavkaOtpremnice stavka);

	StavkaOtpremnice findOne(long id);

	void izbrisiStavkuOtpremnice(StavkaOtpremnice stavka);

}
