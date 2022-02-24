package com.poslovna.Poslovna.mapper;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Cenovnik;
import com.poslovna.Poslovna.dto.CenovnikDTO;

@Component
public class CenovnikDTOToCenovnik {

	public Cenovnik konvertujDtoToEntity(CenovnikDTO cenovnikDTO) {
		
		Cenovnik cenovnik = new Cenovnik();
		
		cenovnik.setCene(cenovnikDTO.getCene());
		cenovnik.setId(cenovnikDTO.getId());
		cenovnik.setKrajRokaTrajanja(cenovnikDTO.getKrajRokaTrajanja());
		cenovnik.setObrisano(cenovnikDTO.isObrisano());
		cenovnik.setPocetakRokaTrajanja(cenovnikDTO.getPocetakRokaTrajanja());
		cenovnik.setPoslovniPartner(cenovnikDTO.getPoslovniPartner());
		cenovnik.setPreduzece(cenovnikDTO.getPreduzece());
		
		
		return cenovnik;
	}
}
