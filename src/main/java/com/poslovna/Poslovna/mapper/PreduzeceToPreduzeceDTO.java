package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.dto.PreduzeceDTO;


@Component
public class PreduzeceToPreduzeceDTO {


		

	public PreduzeceDTO konvertujEntityToDto(Preduzece preduzece) {
		PreduzeceDTO preduzeceDTO = new PreduzeceDTO();
		
		preduzeceDTO.setAdresa(preduzece.getAdresa());
		preduzeceDTO.setEmailAdresa(preduzece.getAdresa());
		preduzeceDTO.setId(preduzece.getId());
		preduzeceDTO.setMesto(preduzece.getMesto());
		preduzeceDTO.setNazivPreduzeca(preduzece.getNazivPreduzeca());
		preduzeceDTO.setPIB(preduzece.getPIB());
		preduzeceDTO.setTekuciRacun(preduzece.getTekuciRacun());
		preduzeceDTO.setTelefon(preduzece.getTelefon());
		
		return preduzeceDTO;
	}

	public List<PreduzeceDTO> konvertujEntityToDto(List<Preduzece> preduzeca) {
		List<PreduzeceDTO> listaPreduzeca = new ArrayList<PreduzeceDTO>();
		for (Preduzece preduzece : preduzeca) {
			listaPreduzeca.add(konvertujEntityToDto(preduzece));
		}
		return listaPreduzeca;
	}
	
}
