package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.StavkaNarudzbenice;
import com.poslovna.Poslovna.dto.StavkaNarudzbeniceDTO;

@Component
public class StavkaNarudzbeniceToStavkaNarudzbeniceDTO {
	
	@Autowired
	private ModelMapper modelMapper;

	public StavkaNarudzbeniceDTO konvertujEntityToDto(StavkaNarudzbenice stavkaNarudzbenice) {

		return modelMapper.map(stavkaNarudzbenice, StavkaNarudzbeniceDTO.class);
	}

	public List<StavkaNarudzbeniceDTO> konvertujEntityToDto(List<StavkaNarudzbenice> stavkeNarudzbenice) {
		List<StavkaNarudzbeniceDTO> listaStavki = new ArrayList<StavkaNarudzbeniceDTO>();
		for (StavkaNarudzbenice stavkeNarudzbenica : stavkeNarudzbenice) {
			listaStavki.add(konvertujEntityToDto(stavkeNarudzbenica));
		}
		return listaStavki;
	}
}

