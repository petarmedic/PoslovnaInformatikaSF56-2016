package com.poslovna.Poslovna.mapper;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StavkaFakture;
import com.poslovna.Poslovna.dto.StavkaFaktureDTO;
@Component
public class StavkaFaktureDTOToStavkaFakture {

	public StavkaFakture konvertujDtoToEntity(StavkaFaktureDTO stavkaFaktureDTO) {
		
		StavkaFakture stavkaFakture = new StavkaFakture();
		
		stavkaFakture.setCena(stavkaFaktureDTO.getCena());
		stavkaFakture.setFaktura(stavkaFaktureDTO.getFaktura());
		stavkaFakture.setId(stavkaFaktureDTO.getId());
		stavkaFakture.setIznosPDV(stavkaFaktureDTO.getIznosPDV());
		stavkaFakture.setKolicina(stavkaFaktureDTO.getKolicina());
		stavkaFakture.setObrisano(stavkaFaktureDTO.isObrisano());
		stavkaFakture.setOsnovicaPDV(stavkaFaktureDTO.getOsnovicaPDV());
		stavkaFakture.setProcenatPDV(stavkaFaktureDTO.getProcenatPDV());
		stavkaFakture.setRabat(stavkaFaktureDTO.getRabat());
		stavkaFakture.setRoba(stavkaFaktureDTO.getRoba());
		stavkaFakture.setUkupanIznos(stavkaFaktureDTO.getUkupanIznos());
		
		return stavkaFakture;
	}
}
