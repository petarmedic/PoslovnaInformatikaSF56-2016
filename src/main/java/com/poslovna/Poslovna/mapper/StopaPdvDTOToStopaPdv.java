package com.poslovna.Poslovna.mapper;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StopaPdv;
import com.poslovna.Poslovna.dto.StopaPdvDTO;

@Component
public class StopaPdvDTOToStopaPdv {

	public StopaPdv konvertujDtoToEntity(StopaPdvDTO stopaPdvDTO) {
		
		StopaPdv stopaPdv = new StopaPdv();
		stopaPdv.setId(stopaPdvDTO.getId());
		stopaPdv.setPdv(stopaPdvDTO.getPdv());
		stopaPdv.setObrisano(stopaPdvDTO.isObrisano());
		stopaPdv.setProcenat(stopaPdvDTO.getProcenat());
		stopaPdv.setRokVazenja(stopaPdvDTO.getRokVazenja());

		return stopaPdv;
	}
}
