package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Roba;
import com.poslovna.Poslovna.dto.RobaDTO;

@Component
public class RobaToRobaDTO {

	public RobaDTO konvertujEntityToDto(Roba roba) {
		
		RobaDTO robaDTO = new RobaDTO();
		
		robaDTO.setGrupaRobe(roba.getGrupaRobe());
		robaDTO.setId(roba.getId());
		robaDTO.setJedinicaMere(roba.getJedinicaMere());
		robaDTO.setNazivRobe(roba.getNazivRobe());
		robaDTO.setObrisano(roba.isObrisano());
		robaDTO.setStavkeCenovnika(roba.getStavkeCenovnika());
		robaDTO.setStavkeFakture(roba.getStavkeFakture());
		
		return robaDTO;
	}
	
	public List<RobaDTO> konvertujEntityToDto(List<Roba> robaLista) {
		List<RobaDTO> listaRobe = new ArrayList<RobaDTO>();
		for (Roba roba : robaLista) {
			listaRobe.add(konvertujEntityToDto(roba));
		}
		return listaRobe;
	}
}
