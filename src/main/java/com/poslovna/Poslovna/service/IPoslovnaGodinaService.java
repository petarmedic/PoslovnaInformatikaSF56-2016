package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.PoslovnaGodina;

public interface IPoslovnaGodinaService {

	List<PoslovnaGodina> findAll();

	PoslovnaGodina getOne(long id);

	List<PoslovnaGodina> findByZakljucenaGodinaIsFalseAndObrisanoIsFalse();

}
