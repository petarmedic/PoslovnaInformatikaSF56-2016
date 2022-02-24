package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StavkaOtpremnice;
import com.poslovna.Poslovna.dto.StavkaOtpremniceDTO;

@Component
public class StavkaOtpremniceToStavkaOtpremniceDTO {
	
	@Autowired
	private ModelMapper modelMapper;

	public StavkaOtpremniceDTO konvertujEntityToDto(StavkaOtpremnice stavkaOtpremnice) {

		return modelMapper.map(stavkaOtpremnice, StavkaOtpremniceDTO.class);
	}

	public List<StavkaOtpremniceDTO> konvertujEntityToDto(List<StavkaOtpremnice> stavkeOtpremnice) {
		List<StavkaOtpremniceDTO> listaStavki = new ArrayList<StavkaOtpremniceDTO>();
		for (StavkaOtpremnice stavkaOtpremnice : stavkeOtpremnice) {
			listaStavki.add(konvertujEntityToDto(stavkaOtpremnice));
		}
		return listaStavki;
	}

}
