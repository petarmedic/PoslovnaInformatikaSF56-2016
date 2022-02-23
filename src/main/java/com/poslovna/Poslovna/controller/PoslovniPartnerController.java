package com.poslovna.Poslovna.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poslovna.Poslovna.domain.Mesto;
import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.domain.PoslovniPartner.TipPoslovnogPartnera;
import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.dto.PoslovniPartnerDTO;
import com.poslovna.Poslovna.mapper.MestoToMestoDTO;
import com.poslovna.Poslovna.mapper.PoslovniPartnerDTOToPoslovniPartner;
import com.poslovna.Poslovna.mapper.PoslovniPartnerToPoslovniPartnerDTO;
import com.poslovna.Poslovna.service.IMestoService;
import com.poslovna.Poslovna.service.IPoslovniPartnerService;
import com.poslovna.Poslovna.service.IPreduzeceService;

@Controller
public class PoslovniPartnerController {
	
	@Autowired
	private IPoslovniPartnerService poslovniPartnerServiceInterface;

	@Autowired
	IMestoService mestoService;

	@Autowired
	IPreduzeceService preduzeceService;

	@Autowired
	private PoslovniPartnerDTOToPoslovniPartner dtoToPoslovniPartner;

	@Autowired
	private PoslovniPartnerToPoslovniPartnerDTO poslovniPartnertoDto;

	@Autowired
	MestoToMestoDTO mestoToMestoDTO;

	@GetMapping("/poslovniPartneri")
	public String getAll(@RequestParam(value = "tipPoslovnogPartnera", defaultValue = "3") int tip, Model model) {
		List<PoslovniPartner> poslovniPartneri = poslovniPartnerServiceInterface.findAll();
		tip = Integer.valueOf(tip);
		if (tip == 3) {
			List<PoslovniPartnerDTO> poslovniPartnerDTO = poslovniPartnertoDto.konvertujEntityToDto(poslovniPartneri);
			model.addAttribute("tipPoslovnogPartnera", tip);
			model.addAttribute("poslovniPartneri", poslovniPartnerDTO);

			return "poslovniPartneri";
		}

		int finalTip = tip;
		List<PoslovniPartner> poslovniPartnerFilter = poslovniPartneri.stream()
				.filter(p -> p.getTipPoslovnogPartnera() == TipPoslovnogPartnera.valueOf(finalTip))
				.collect(Collectors.toList());
		model.addAttribute("tipPoslovnogPartneraFilter", finalTip);
		model.addAttribute("poslovniPartneriFilter", poslovniPartnertoDto.konvertujEntityToDto(poslovniPartnerFilter));

		return "poslovniPartneri";

	}

	@GetMapping("/poslovniPartneri/azuriraj/{id}")
	public String vratiPreduzeca(Model model, @PathVariable Long id) {
		PoslovniPartner poslovniPartner = poslovniPartnerServiceInterface.findOne(id);
		PoslovniPartnerDTO poslovniPartnerDTO = poslovniPartnertoDto.konvertujEntityToDto(poslovniPartner);
		List<Mesto> listaMesta = mestoService.findAll();
		model.addAttribute("listaMesta", mestoToMestoDTO.konvertujEntityToDto(listaMesta));
		model.addAttribute("poslovniPartner", poslovniPartnerDTO);

		return "azurirajPoslovnogPartnera";
	}

	@PostMapping("/poslovniPartneri/azuriraj")
	public String azurirajPoslovnogPartnera(PoslovniPartnerDTO poslovniPartnerDTO) {
		PoslovniPartner partner = dtoToPoslovniPartner.konvertujDtoToEntity(poslovniPartnerDTO);
		partner.setPreduzece(preduzeceService.findAll().get(0));
		poslovniPartnerServiceInterface.save(partner);

		return "redirect:/poslovniPartneri";
	}

	@GetMapping("poslovniPartner/dodavanje")
	public String dodajPoslovnogPartnera(Model model) {
		List<Mesto> listaMesta = mestoService.findAll();
		model.addAttribute("listaMesta", mestoToMestoDTO.konvertujEntityToDto(listaMesta));
		model.addAttribute("poslovniPartner", new PoslovniPartnerDTO());

		return "dodajPoslovnogPartnera";
	}

	@PostMapping("poslovniPartner/dodavanje")
	public String dodajPoslovnogPartnera(PoslovniPartnerDTO poslovniPartnerDTO) {
		List<Preduzece> preduzeca = preduzeceService.findAll();
		PoslovniPartner partner = dtoToPoslovniPartner.konvertujDtoToEntity(poslovniPartnerDTO);
		partner.setPreduzece(preduzeca.get(0));
		partner.setObrisano(false);
		poslovniPartnerServiceInterface.save(partner);

		return "redirect:/poslovniPartneri";
	}
	
	@DeleteMapping("/poslovniPartner/izbrisi")
	public String izbrisiPoslovnogPartnera(Long poslovniPartnerIdDelete) {
		PoslovniPartner poslovniPartner = poslovniPartnerServiceInterface.findOne(poslovniPartnerIdDelete);
		poslovniPartnerServiceInterface.izbrisiPoslovnogPartnera(poslovniPartner);
		
		return "redirect:/poslovniPartneri";
	}


}
