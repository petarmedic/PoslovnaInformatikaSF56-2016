package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.Narudzbenica;
import com.poslovna.Poslovna.dto.NarudzbenicaDTO;

public interface INarudzbenicaService {

	List<Narudzbenica> findAll();

	Narudzbenica getOne(long id);

	void save(Narudzbenica narudzbenica);

	void kreirajFakturuOdNarudzbenice(NarudzbenicaDTO narudzbenicaDTO, int poslednjaPoslovnjaGodina);

}
