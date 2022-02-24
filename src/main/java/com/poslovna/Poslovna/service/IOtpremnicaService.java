package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.Otpremnica;
import com.poslovna.Poslovna.dto.OtpremnicaDTO;

public interface IOtpremnicaService {

	void update(Otpremnica otpremnica);

	Otpremnica getOne(long idotpremnice);

	void save(Otpremnica otpremnica);

	List<Otpremnica> findAll();

	void kreirajFakturuOdOtpremnice(OtpremnicaDTO otpremnicaDTO, int brojFakture);

}
