package com.poslovna.Poslovna.mapper;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Pdv;
import com.poslovna.Poslovna.dto.PdvDTO;

@Component
public class PdvDTOToPdv {
	
	public Pdv konvertujDtoToEntity(PdvDTO pdvDTO) {
		
		Pdv pdv = new Pdv();
		pdv.setId(pdvDTO.getId());
		pdv.setGrupeRobe(pdvDTO.getGrupeRobe());
		pdv.setStopePdv(pdvDTO.getStopePdv());
		pdv.setVrstaPdv(pdvDTO.getVrstaPdv());
		pdv.setObrisano(pdvDTO.isObrisano());
		
		return pdv;
	}
}
