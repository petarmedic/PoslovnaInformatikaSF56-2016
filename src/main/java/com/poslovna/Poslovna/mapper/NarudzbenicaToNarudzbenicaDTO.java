package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Narudzbenica;
import com.poslovna.Poslovna.dto.NarudzbenicaDTO;

@Component
public class NarudzbenicaToNarudzbenicaDTO {

	@Autowired
	private ModelMapper modelMapper;

	public NarudzbenicaDTO konvertujEntityToDto(Narudzbenica narudzbenica) {

		return modelMapper.map(narudzbenica, NarudzbenicaDTO.class);
	}

	public List<NarudzbenicaDTO> konvertujEntityToDto(List<Narudzbenica> narudzbenice) {
		List<NarudzbenicaDTO> listaNarudzbenica = new ArrayList<NarudzbenicaDTO>();
		for (Narudzbenica narudzbenica : narudzbenice) {
			listaNarudzbenica.add(konvertujEntityToDto(narudzbenica));
		}
		return listaNarudzbenica;
	}
}
