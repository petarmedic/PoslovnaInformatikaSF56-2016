package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.dto.PoslovniPartnerDTO;

@Component
public class PoslovniPartnerToPoslovniPartnerDTO {

	public PoslovniPartnerDTO konvertujEntityToDto(PoslovniPartner poslovniPartner) {
		
		PoslovniPartnerDTO poslovniPartnerDTO = new PoslovniPartnerDTO();
		
		poslovniPartnerDTO.setId(poslovniPartner.getId());
		poslovniPartnerDTO.setPIB(poslovniPartner.getPIB());
		poslovniPartnerDTO.setNazivPoslovnogPartnera(poslovniPartner.getNazivPoslovnogPartnera());
		poslovniPartnerDTO.setAdresa(poslovniPartner.getAdresa());
		poslovniPartnerDTO.setObrisano(poslovniPartner.isObrisano());
		poslovniPartnerDTO.setTekuciRacun(poslovniPartner.getTekuciRacun());
		poslovniPartnerDTO.setTipPoslovnogPartnera(poslovniPartner.getTipPoslovnogPartnera());
		poslovniPartnerDTO.setMesto(poslovniPartner.getMesto());
		poslovniPartnerDTO.setPreduzece(poslovniPartner.getPreduzece());
		
		return poslovniPartnerDTO;
	}
	
	public List<PoslovniPartnerDTO> konvertujEntityToDto(List<PoslovniPartner> poslovniPartneri) {
		List<PoslovniPartnerDTO> listaPoslovnihPartneraDTO = new ArrayList<PoslovniPartnerDTO>();
		for (PoslovniPartner poslovniPartner : poslovniPartneri) {
			listaPoslovnihPartneraDTO.add(konvertujEntityToDto(poslovniPartner));
		}

		return listaPoslovnihPartneraDTO;
	}
}
