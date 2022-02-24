package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.GrupaRobe;
import com.poslovna.Poslovna.dto.GrupaRobeDTO;

@Component
public class GrupaRobeToGrupaRobeDTO {

	public GrupaRobeDTO konvertujEntityToDto(GrupaRobe grupaRobe) {
		
		GrupaRobeDTO grupaRobeDTO = new GrupaRobeDTO();
		
		grupaRobeDTO.setId(grupaRobe.getId());
		grupaRobeDTO.setNaziv(grupaRobe.getNaziv());
		grupaRobeDTO.setObrisano(grupaRobe.isObrisano());
		grupaRobeDTO.setPdv(grupaRobe.getPdv());
		grupaRobeDTO.setPreduzece(grupaRobe.getPreduzece());
		
		return grupaRobeDTO;
	}
	
	
	public List<GrupaRobeDTO> konvertujEntityToDto(List<GrupaRobe> grupaRobeLista) {
		List<GrupaRobeDTO> grupeRoba = new ArrayList<GrupaRobeDTO>();
		for (GrupaRobe grupaRobe : grupaRobeLista) {
			grupeRoba.add(konvertujEntityToDto(grupaRobe));
		}
		return grupeRoba;
	}
}
