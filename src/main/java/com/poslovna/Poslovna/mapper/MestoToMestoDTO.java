package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Mesto;
import com.poslovna.Poslovna.dto.MestoDTO;

@Component
public class MestoToMestoDTO {


	public MestoDTO konvertujEntityToDto(Mesto mesto) {
		MestoDTO mestoDTO = new MestoDTO();
		mestoDTO.setGrad(mesto.getGrad());
		mestoDTO.setId(mesto.getId());
		mestoDTO.setObrisano(mesto.isObrisano());
		mestoDTO.setPostanskiBroj(mesto.getPostanskiBroj());
		
		return mestoDTO;
	}

	public List<MestoDTO> konvertujEntityToDto(List<Mesto> mesta) {
		List<MestoDTO> listaMesta = new ArrayList<MestoDTO>();
		for (Mesto mesto : mesta) {
			listaMesta.add(konvertujEntityToDto(mesto));
		}
		return listaMesta;
	}

}
