package com.poslovna.Poslovna.mapper;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.GrupaRobe;
import com.poslovna.Poslovna.dto.GrupaRobeDTO;

@Component
public class GrupaRobeDTOToGrupaRobe {

	public GrupaRobe konvertujDtoToEntity(GrupaRobeDTO grupaRobeDTO) {
		
		GrupaRobe grupaRobe = new GrupaRobe();
		grupaRobe.setId(grupaRobeDTO.getId());
		grupaRobe.setNaziv(grupaRobeDTO.getNaziv());
		grupaRobe.setObrisano(grupaRobeDTO.isObrisano());
		grupaRobe.setPdv(grupaRobeDTO.getPdv());
		grupaRobe.setPreduzece(grupaRobeDTO.getPreduzece());
		
		return grupaRobe;
	}
}
