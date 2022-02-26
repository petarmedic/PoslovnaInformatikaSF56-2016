package com.poslovna.Poslovna.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.Poslovna.domain.GrupaRobe;
import com.poslovna.Poslovna.dto.GrupaRobeDTO;

@Component
public class GrupaRobeToStopaGrupaRobeDTO {

	@Autowired
	private ModelMapper modelMapper;

	public GrupaRobeDTO konvertujEntityToDto(GrupaRobe grupaRobe) {

		return modelMapper.map(grupaRobe, GrupaRobeDTO.class);
	}

	public List<GrupaRobeDTO> konvertujEntityToDto(List<GrupaRobe> grupaRobeLista) {
		List<GrupaRobeDTO> grupeRoba = new ArrayList<GrupaRobeDTO>();
		for (GrupaRobe grupaRobe : grupaRobeLista) {
			grupeRoba.add(konvertujEntityToDto(grupaRobe));
		}
		return grupeRoba;
	}

}
