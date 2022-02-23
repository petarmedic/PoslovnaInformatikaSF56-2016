package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Pdv;
import com.poslovna.Poslovna.dto.PdvDTO;


@Component
public class PdvToPdvDTO {

	public PdvDTO konvertujEntityToDto (Pdv pdv) {
		
		PdvDTO pdvDTO = new PdvDTO();
		
		pdvDTO.setId(pdv.getId());
		pdvDTO.setGrupeRobe(pdv.getGrupeRobe());
		pdvDTO.setStopePdv(pdv.getStopePdv());
		pdvDTO.setVrstaPdv(pdv.getVrstaPdv());
		pdvDTO.setObrisano(pdv.isObrisano());
		
		return pdvDTO;
	}
	
	public List<PdvDTO> konvertujEntityToDto(List<Pdv> pdvLista) {
		List<PdvDTO> listaPdv = new ArrayList<PdvDTO>();
		for (Pdv pdv : pdvLista) {
			listaPdv.add(konvertujEntityToDto(pdv));
		}
		return listaPdv;
	}
}
