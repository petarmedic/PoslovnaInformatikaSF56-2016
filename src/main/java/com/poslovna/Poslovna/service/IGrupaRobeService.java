package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.GrupaRobe;

public interface IGrupaRobeService {

	GrupaRobe findOne(Long id);

	List<GrupaRobe> findAll();

	void save(GrupaRobe grupaRobe);

	void izbrisiGrupuRobe(GrupaRobe grupaRobe);

	void izbrisiGrupuRobeByPdvId(Long pdvId);

}
