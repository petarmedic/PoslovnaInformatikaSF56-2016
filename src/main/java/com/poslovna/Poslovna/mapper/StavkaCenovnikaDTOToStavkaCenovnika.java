package com.poslovna.Poslovna.mapper;

import com.poslovna.Poslovna.dto.StavkaCenovnikaDTO;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StavkaCenovnika;

@Component
public class StavkaCenovnikaDTOToStavkaCenovnika {

	public StavkaCenovnika konvertujDtoToEntity (StavkaCenovnikaDTO stavkaCenovnikaDTO) {
		
		StavkaCenovnika stavkaCenovnika = new StavkaCenovnika();
		
		stavkaCenovnika.setCena(stavkaCenovnikaDTO.getCena());
		stavkaCenovnika.setCenovnik(stavkaCenovnikaDTO.getCenovnik());
		stavkaCenovnika.setId(stavkaCenovnikaDTO.getId());
		stavkaCenovnika.setObrisano(stavkaCenovnikaDTO.isObrisano());
		stavkaCenovnika.setRoba(stavkaCenovnikaDTO.getRoba());
		
		return stavkaCenovnika;
	}
}
