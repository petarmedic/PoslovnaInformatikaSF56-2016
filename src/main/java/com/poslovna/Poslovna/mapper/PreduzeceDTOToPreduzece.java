package com.poslovna.Poslovna.mapper;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.dto.PreduzeceDTO;

@Component
public class PreduzeceDTOToPreduzece {
	
	public Preduzece konvertujDtoToEntity(PreduzeceDTO preduzeceDTO) {

		Preduzece preduzece = new Preduzece();
		preduzece.setAdresa(preduzeceDTO.getAdresa());
		preduzece.setEmailAdresa(preduzeceDTO.getAdresa());
		preduzece.setId(preduzeceDTO.getId());
		preduzece.setMesto(preduzeceDTO.getMesto());
		preduzece.setNazivPreduzeca(preduzeceDTO.getNazivPreduzeca());
		preduzece.setPIB(preduzeceDTO.getPIB());
		preduzece.setTekuciRacun(preduzeceDTO.getTekuciRacun());
		preduzece.setTelefon(preduzeceDTO.getTelefon());
		
		return preduzece;
	}
}
