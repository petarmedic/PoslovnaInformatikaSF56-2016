package com.poslovna.Poslovna.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.dto.PoslovniPartnerDTO;


@Component
public class PoslovniPartnerDTOToPoslovniPartner {

	@Autowired
	private ModelMapper modelMapper;

	public PoslovniPartner konvertujDTOToEntity(PoslovniPartnerDTO poslovniPartnerDTO) {
		PoslovniPartner poslovniPartner = modelMapper.map(poslovniPartnerDTO, PoslovniPartner.class);

		return poslovniPartner;
	}
}
