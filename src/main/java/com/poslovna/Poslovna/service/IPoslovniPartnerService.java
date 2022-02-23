package com.poslovna.Poslovna.service;

import java.util.List;

import com.poslovna.Poslovna.domain.PoslovniPartner;

public interface IPoslovniPartnerService {

	List<PoslovniPartner> findAll();

	PoslovniPartner findOne(Long id);

	void save(PoslovniPartner poslovniPartner);

	void izbrisiPoslovnogPartnera(PoslovniPartner poslovniPartner);

	void izbrisiPoslovnogPartneraByMestoId(Long mestoId);

}
