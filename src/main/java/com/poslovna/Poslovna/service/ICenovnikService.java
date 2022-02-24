package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.Cenovnik;

public interface ICenovnikService {

	List<Cenovnik> findAll();

	Cenovnik findOne(long id);

	void save(Cenovnik cenovnik);

}
