package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StavkaFakture;
import com.poslovna.Poslovna.dto.StavkaFaktureDTO;
@Component
public class StavkaFaktureToStavkaFaktureDTO {

	public StavkaFaktureDTO konvertujEntityToDto(StavkaFakture stavkaFakture) {
		StavkaFaktureDTO stavkaFaktureDTO = new StavkaFaktureDTO();
		
		stavkaFaktureDTO.setCena(stavkaFakture.getCena());
		stavkaFaktureDTO.setFaktura(stavkaFakture.getFaktura());
		stavkaFaktureDTO.setId(stavkaFakture.getId());
		stavkaFaktureDTO.setIznosPDV(stavkaFakture.getIznosPDV());
		stavkaFaktureDTO.setKolicina(stavkaFakture.getKolicina());
		stavkaFaktureDTO.setObrisano(stavkaFakture.isObrisano());
		stavkaFaktureDTO.setOsnovicaPDV(stavkaFakture.getOsnovicaPDV());
		stavkaFaktureDTO.setProcenatPDV(stavkaFakture.getProcenatPDV());
		stavkaFaktureDTO.setRabat(stavkaFakture.getRabat());
		stavkaFaktureDTO.setRoba(stavkaFakture.getRoba());
		stavkaFaktureDTO.setUkupanIznos(stavkaFakture.getUkupanIznos());
		
		return stavkaFaktureDTO;
	}
	
	public List<StavkaFaktureDTO> konvertujEntityToDto(List<StavkaFakture> stavkeFakture) {
		List<StavkaFaktureDTO> stavkeFakturaList = new ArrayList<StavkaFaktureDTO>();
		for (StavkaFakture stavkaFakture : stavkeFakture) {
			stavkeFakturaList.add(konvertujEntityToDto(stavkaFakture));
		}
		return stavkeFakturaList;
	}
}
