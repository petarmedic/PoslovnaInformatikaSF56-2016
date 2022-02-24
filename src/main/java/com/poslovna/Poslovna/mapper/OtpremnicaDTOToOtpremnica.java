package com.poslovna.Poslovna.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Otpremnica;
import com.poslovna.Poslovna.dto.OtpremnicaDTO;

@Component
public class OtpremnicaDTOToOtpremnica {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Otpremnica konvertujDtoToEntity(OtpremnicaDTO otpremnicaDTO) {
		
		Otpremnica otpremnica = modelMapper.map(otpremnicaDTO, Otpremnica.class);
		return otpremnica;
	}

}

