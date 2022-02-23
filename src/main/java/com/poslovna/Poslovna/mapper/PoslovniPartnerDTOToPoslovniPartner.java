package com.poslovna.Poslovna.mapper;

import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.dto.PoslovniPartnerDTO;


@Component
public class PoslovniPartnerDTOToPoslovniPartner {

	public PoslovniPartner konvertujDtoToEntity(PoslovniPartnerDTO poslovniPartnerDTO) {
		
		PoslovniPartner poslovniPartner = new PoslovniPartner();
		poslovniPartner.setId(poslovniPartnerDTO.getId());
		poslovniPartner.setPIB(poslovniPartnerDTO.getPIB());
		poslovniPartner.setNazivPoslovnogPartnera(poslovniPartnerDTO.getNazivPoslovnogPartnera());
		poslovniPartner.setAdresa(poslovniPartnerDTO.getAdresa());
		poslovniPartner.setObrisano(poslovniPartnerDTO.isObrisano());
		poslovniPartner.setTekuciRacun(poslovniPartnerDTO.getTekuciRacun());
		poslovniPartner.setTipPoslovnogPartnera(poslovniPartnerDTO.getTipPoslovnogPartnera());
		poslovniPartner.setMesto(poslovniPartnerDTO.getMesto());
		poslovniPartner.setPreduzece(poslovniPartnerDTO.getPreduzece());
		
		return poslovniPartner;
	}
}
