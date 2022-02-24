package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.PoslovnaGodina;
import com.poslovna.Poslovna.dto.PoslovnaGodinaDTO;

@Component
public class PoslovnaGodinaToPoslovnaGodinaDTO {
	
	@Autowired
	private ModelMapper modelMapper;

	public PoslovnaGodinaDTO konvertujEntityToDto(PoslovnaGodina poslovnaGodina) {

		return modelMapper.map(poslovnaGodina, PoslovnaGodinaDTO.class);
	}

	public List<PoslovnaGodinaDTO> konvertujEntityToDto(List<PoslovnaGodina> poslovneGodine) {
		List<PoslovnaGodinaDTO> listaPoslovnihGodina = new ArrayList<PoslovnaGodinaDTO>();
		for (PoslovnaGodina poslovnaGodina : poslovneGodine) {
			listaPoslovnihGodina.add(konvertujEntityToDto(poslovnaGodina));
		}
		return listaPoslovnihGodina;
	}

}
