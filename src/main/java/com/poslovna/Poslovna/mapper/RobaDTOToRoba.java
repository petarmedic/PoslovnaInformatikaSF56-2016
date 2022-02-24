package com.poslovna.Poslovna.mapper;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Roba;
import com.poslovna.Poslovna.dto.RobaDTO;

@Component
public class RobaDTOToRoba {

	public Roba konvertujDtoToEntity(RobaDTO robaDTO) {
		
		Roba roba = new Roba();
		roba.setGrupaRobe(robaDTO.getGrupaRobe());
		roba.setId(robaDTO.getId());
		roba.setJedinicaMere(robaDTO.getJedinicaMere());
		roba.setNazivRobe(robaDTO.getNazivRobe());
		roba.setObrisano(robaDTO.isObrisano());
		roba.setStavkeCenovnika(robaDTO.getStavkeCenovnika());
		roba.setStavkeFakture(robaDTO.getStavkeFakture());
		
		
		return roba;
	}
}
