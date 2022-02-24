package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.Cenovnik;
import com.poslovna.Poslovna.dto.CenovnikDTO;

@Component
public class CenovnikToCenovnikDTO {

	public CenovnikDTO konvertujEntityToDto(Cenovnik cenovnik) {
		CenovnikDTO cenovnikDTO = new CenovnikDTO();
		
		cenovnikDTO.setCene(cenovnik.getCene());
		cenovnikDTO.setId(cenovnik.getId());
		cenovnikDTO.setKrajRokaTrajanja(cenovnik.getKrajRokaTrajanja());
		cenovnikDTO.setObrisano(cenovnik.isObrisano());
		cenovnikDTO.setPocetakRokaTrajanja(cenovnik.getPocetakRokaTrajanja());
		cenovnikDTO.setPoslovniPartner(cenovnik.getPoslovniPartner());
		cenovnikDTO.setPreduzece(cenovnik.getPreduzece());
		
		
		return cenovnikDTO;
	}
	
	public List<CenovnikDTO> konvertujEntityToDto(List<Cenovnik> cenovnici) {
		List<CenovnikDTO> listaCenovnika = new ArrayList<CenovnikDTO>();
		for (Cenovnik cenovnik : cenovnici) {
			listaCenovnika.add(konvertujEntityToDto(cenovnik));
		}
		return listaCenovnika;
	}
}
