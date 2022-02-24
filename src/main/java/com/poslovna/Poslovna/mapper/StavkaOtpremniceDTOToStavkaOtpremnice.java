package com.poslovna.Poslovna.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StavkaOtpremnice;
import com.poslovna.Poslovna.dto.StavkaOtpremniceDTO;

@Component
public class StavkaOtpremniceDTOToStavkaOtpremnice {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public StavkaOtpremnice konvertujDtoToEntity(StavkaOtpremniceDTO stavkaOtpremniceDTO) {
		
		StavkaOtpremnice stavkaOtpremnice = modelMapper.map(stavkaOtpremniceDTO, StavkaOtpremnice.class);
		return stavkaOtpremnice;
	}

}

