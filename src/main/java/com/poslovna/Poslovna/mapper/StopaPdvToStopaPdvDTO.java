package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StopaPdv;
import com.poslovna.Poslovna.dto.StopaPdvDTO;

@Component
public class StopaPdvToStopaPdvDTO {

	public StopaPdvDTO konvertujEntityToDto(StopaPdv stopaPdv) {
		
		StopaPdvDTO stopaPdvDTO = new StopaPdvDTO();
		stopaPdvDTO.setId(stopaPdv.getId());
		stopaPdvDTO.setPdv(stopaPdv.getPdv());
		stopaPdvDTO.setObrisano(stopaPdv.isObrisano());
		stopaPdvDTO.setProcenat(stopaPdv.getProcenat());
		stopaPdvDTO.setRokVazenja(stopaPdv.getRokVazenja());
		
		
		return stopaPdvDTO;
	}
	
	public List<StopaPdvDTO> konvertujEntityToDto(List<StopaPdv> stopaPdvLista) {
		List<StopaPdvDTO> stopePdv = new ArrayList<StopaPdvDTO>();
		for (StopaPdv stopaPdv : stopaPdvLista) {
			stopePdv.add(konvertujEntityToDto(stopaPdv));
		}
		return stopePdv;
	}
}
