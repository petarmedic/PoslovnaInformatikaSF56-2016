package com.poslovna.Poslovna.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.PoslovnaGodina;
import com.poslovna.Poslovna.dto.PoslovnaGodinaDTO;

@Component
public class PoslovnaGodinaDTOToPoslovnaGodina {


	@Autowired
	private ModelMapper modelMapper;
	
	public PoslovnaGodina konvertujDtoToEntity(PoslovnaGodinaDTO poslovnaGodinaDTO) {
		
		PoslovnaGodina poslovnaGodina = modelMapper.map(poslovnaGodinaDTO, PoslovnaGodina.class);
		return poslovnaGodina;
	}
}
