package com.poslovna.Poslovna.mapper;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Mesto;
import com.poslovna.Poslovna.dto.MestoDTO;



@Component
public class MestoDTOToMesto {

	public Mesto konvertujDtoToEntity(MestoDTO mestoDTO) {
		Mesto mesto = new Mesto();
		mesto.setId(mestoDTO.getId());
		mesto.setGrad(mestoDTO.getGrad());
		mesto.setPostanskiBroj(mestoDTO.getPostanskiBroj());
		mesto.setObrisano(mestoDTO.isObrisano());
		
		return mesto;
	}
}
