package com.poslovna.Poslovna.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StavkaNarudzbenice;
import com.poslovna.Poslovna.dto.StavkaNarudzbeniceDTO;

@Component
public class StavkaNarudzbeniceDTOToStavkaNarudzbenice {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public StavkaNarudzbenice konvertujDtoToEntity(StavkaNarudzbeniceDTO stavkaNarudzbeniceDTO) {
		
		StavkaNarudzbenice stavkaNarudzbenice = modelMapper.map(stavkaNarudzbeniceDTO, StavkaNarudzbenice.class);
		return stavkaNarudzbenice;
	}
}

