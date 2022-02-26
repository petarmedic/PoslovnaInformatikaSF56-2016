package com.poslovna.Poslovna.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Narudzbenica;
import com.poslovna.Poslovna.dto.NarudzbenicaDTO;

@Component
public class NarudzbenicaDTOToNarudzbenica {

	@Autowired
	private ModelMapper modelMapper;
	
	public Narudzbenica konvertujDtoToEntity(NarudzbenicaDTO narudzbenicaDTO) {
		
		Narudzbenica narudzbenica = modelMapper.map(narudzbenicaDTO, Narudzbenica.class);
		return narudzbenica;
	}
}

