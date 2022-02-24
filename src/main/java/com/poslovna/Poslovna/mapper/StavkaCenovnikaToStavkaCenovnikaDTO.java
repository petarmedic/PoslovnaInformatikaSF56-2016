package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StavkaCenovnika;
import com.poslovna.Poslovna.dto.StavkaCenovnikaDTO;

@Component
public class StavkaCenovnikaToStavkaCenovnikaDTO {

	public StavkaCenovnikaDTO konvertujEntityToDto(StavkaCenovnika stavkaCenovnika) {
		
		StavkaCenovnikaDTO stavkaCenovnikaDTO = new StavkaCenovnikaDTO();
		
		stavkaCenovnikaDTO.setCena(stavkaCenovnika.getCena());
		stavkaCenovnikaDTO.setCenovnik(stavkaCenovnika.getCenovnik());
		stavkaCenovnikaDTO.setId(stavkaCenovnika.getId());
		stavkaCenovnikaDTO.setObrisano(stavkaCenovnika.isObrisano());
		stavkaCenovnikaDTO.setRoba(stavkaCenovnika.getRoba());
		
		return stavkaCenovnikaDTO;
	}
	
	public List<StavkaCenovnikaDTO> konvertujEntityToDto(List<StavkaCenovnika> stavkeCenovnika) {
		List<StavkaCenovnikaDTO> listaStavki = new ArrayList<StavkaCenovnikaDTO>();
		for (StavkaCenovnika stavkaCenovnika : stavkeCenovnika) {
			listaStavki.add(konvertujEntityToDto(stavkaCenovnika));
		}
		return listaStavki;
	}
}
