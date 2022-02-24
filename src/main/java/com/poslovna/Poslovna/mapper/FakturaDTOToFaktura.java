package com.poslovna.Poslovna.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Faktura;
import com.poslovna.Poslovna.dto.FakturaDTO;

@Component
public class FakturaDTOToFaktura {

	@Autowired
	private ModelMapper modelMapper;
	
	public Faktura konvertujDtoToEntity(FakturaDTO fakturaDTO) {
		
		Faktura faktura = modelMapper.map(fakturaDTO, Faktura.class);
		return faktura;
	}
}
