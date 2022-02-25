package com.poslovna.Poslovna.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.poslovna.Poslovna.domain.Faktura;
import com.poslovna.Poslovna.domain.StavkaFakture;
import com.poslovna.Poslovna.dto.FakturaDTO;
import com.poslovna.Poslovna.mapper.FakturaDTOToFaktura;
import com.poslovna.Poslovna.mapper.FakturaToFakturaDTO;
import com.poslovna.Poslovna.mapper.PoslovniPartnerDTOToPoslovniPartner;
import com.poslovna.Poslovna.mapper.PoslovniPartnerToPoslovniPartnerDTO;
import com.poslovna.Poslovna.mapper.StavkaFaktureToStavkaFaktureDTO;
import com.poslovna.Poslovna.service.IFakturaService;
import com.poslovna.Poslovna.service.IStavkeFaktureService;

@Controller
public class FakturaController {

	@Autowired
	IFakturaService fakturaService;

	@Autowired
	IStavkeFaktureService stavkeFaktureService;

	@Autowired
	FakturaToFakturaDTO fakturaToFakturaDTO;

	@Autowired
	FakturaDTOToFaktura fakturaDTOToFaktura;

	@Autowired
	StavkaFaktureToStavkaFaktureDTO stavkaFaktureToStavkaFaktureDTO;

	@Autowired
	PoslovniPartnerToPoslovniPartnerDTO poslovniPartnerToPoslovniPartnerDTO;

	@Autowired
	PoslovniPartnerDTOToPoslovniPartner poslovniPartnerDTOToPoslovniPartner;

	@GetMapping("/fakture")
	public String getAll(@RequestParam(value = "tipFakture", defaultValue = "false") boolean tip, Model model) {
		List<Faktura> fakture = fakturaService.findAll();
		boolean finalTip = Boolean.valueOf(tip);
		List<Faktura> faktureFilter = fakture.stream().filter(f -> f.isVrstaFakture() == finalTip)
				.collect(Collectors.toList());
		model.addAttribute("tipFakture", finalTip);
		model.addAttribute("fakture", fakturaToFakturaDTO.konvertujEntityToDto(faktureFilter));
		return "fakture";

	}
	
	@GetMapping("faktura/detalji/{idFakture}")
	public String detaljiFakture(Model model, @PathVariable int idFakture) {
		Faktura faktura = fakturaService.getOne(idFakture);
		List<StavkaFakture> stavkeFakture = stavkeFaktureService.findAll().stream()
				.filter(sn -> sn.getFaktura().getId() == idFakture).collect(Collectors.toList());
		FakturaDTO dto = fakturaToFakturaDTO.konvertujEntityToDto(faktura);
		model.addAttribute("faktura", dto);
		model.addAttribute("stavkeFakture", stavkaFaktureToStavkaFaktureDTO.konvertujEntityToDto(stavkeFakture));
		model.addAttribute("poslovniPartner",
				poslovniPartnerToPoslovniPartnerDTO.konvertujEntityToDto(faktura.getPoslovniPartner()));
		return "faktura_detalji";
	}
	
	

	
	
	
	
	@GetMapping("/knjigaIzlaznihFaktura")
	public String getUlazneFakture(Model model) {
		if (!model.containsAttribute("fakture")) {
			List<Faktura> fakture = fakturaService.findAll();
			List<Faktura> faktureFilter = fakture.stream().filter(f -> f.isVrstaFakture() == false)
					.collect(Collectors.toList());
			model.addAttribute("fakture", fakturaToFakturaDTO.konvertujEntityToDto(faktureFilter));
		}
		return "knjigaIzlaznihFaktura";
	}
}
