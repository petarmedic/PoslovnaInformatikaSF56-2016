package com.poslovna.Poslovna.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.poslovna.Poslovna.domain.Otpremnica;
import com.poslovna.Poslovna.domain.PoslovnaGodina;
import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.domain.PoslovniPartner.TipPoslovnogPartnera;
import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.domain.Roba;
import com.poslovna.Poslovna.domain.StavkaOtpremnice;
import com.poslovna.Poslovna.dto.OtpremnicaDTO;
import com.poslovna.Poslovna.mapper.OtpremnicaDTOToOtpremnica;
import com.poslovna.Poslovna.mapper.OtpremnicaToOtpremnicaDTO;
import com.poslovna.Poslovna.mapper.PoslovniPartnerToPoslovniPartnerDTO;
import com.poslovna.Poslovna.mapper.StavkaOtpremniceDTOToStavkaOtpremnice;
import com.poslovna.Poslovna.mapper.StavkaOtpremniceToStavkaOtpremniceDTO;
import com.poslovna.Poslovna.service.IOtpremnicaService;
import com.poslovna.Poslovna.service.IPoslovnaGodinaService;
import com.poslovna.Poslovna.service.IPoslovniPartnerService;
import com.poslovna.Poslovna.service.IPreduzeceService;
import com.poslovna.Poslovna.service.IRobaService;
import com.poslovna.Poslovna.service.IStavkaOtpremniceService;

@Controller
public class OtpremnicaController {
	
	@Autowired
	IOtpremnicaService otpremnicaService;
	
	@Autowired
	IStavkaOtpremniceService stavkaOtpremniceService;
	
	@Autowired
	IPoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	IPreduzeceService preduzeceService;
	
	@Autowired
	IPoslovnaGodinaService poslovnaGodinaService;
	
	@Autowired
	IRobaService robaService;
	
	@Autowired
	OtpremnicaDTOToOtpremnica otpremnicaDTOToOtpremnica;
	
	@Autowired
	OtpremnicaToOtpremnicaDTO otpremnicaToOtpremnicaDTO;
	
	@Autowired
	StavkaOtpremniceDTOToStavkaOtpremnice stavkaOtpremniceDTOToStavkaOtpremnice;
	
	@Autowired
	StavkaOtpremniceToStavkaOtpremniceDTO stavkaOtpremniceToStavkaOtpremniceDTO;
	
	@Autowired
	PoslovniPartnerToPoslovniPartnerDTO poslovniPartnerToPoslovniPartnerDTO;
	
	@GetMapping("/otpremnice")
	public String vratiOtpremnice(Model model) {
		List<Otpremnica> otpremnice = otpremnicaService.findAll();
		model.addAttribute("otpremnice", otpremnicaToOtpremnicaDTO.konvertujEntityToDto(otpremnice));
		return "otpremnice";
	}
	
	@GetMapping("otpremnica/dodavanje")
	public String dodajOtpremnicu(Model model) {
		List<PoslovniPartner> listaPoslovniPartneri = poslovniPartnerService.findAll().stream()
				.filter(pp -> pp.getTipPoslovnogPartnera() == TipPoslovnogPartnera.KUPAC)
				.collect(Collectors.toList());
		model.addAttribute("listaPoslovnihPartnera", poslovniPartnerToPoslovniPartnerDTO.konvertujEntityToDto(listaPoslovniPartneri));
		model.addAttribute("otpremnica", new OtpremnicaDTO());

		return "dodajOtpremnicu";
	}
	

	@PostMapping("otpremnica/dodavanje")
	public String dodajOtpremnicu(OtpremnicaDTO otpremnicaDTO) {
		List<Preduzece> preduzeca = preduzeceService.findAll();
		PoslovnaGodina poslednjaPoslovnaGodina = poslovnaGodinaService.findByZakljucenaGodinaIsFalseAndObrisanoIsFalse().get(0);
		Otpremnica otpremnica = otpremnicaDTOToOtpremnica.konvertujDtoToEntity(otpremnicaDTO);
		otpremnica.setPreduzece(preduzeca.get(0));
		otpremnica.setDatumOtpremnice(new Date());
		otpremnica.setObrisano(false);
		otpremnica.setPoslovnaGodina(poslednjaPoslovnaGodina);
		otpremnica.setBrojOtpremnice(poslednjaPoslovnaGodina.getOtpremnice().size() + 1);
		otpremnica.setTipOtpremnice(false);
        otpremnicaService.save(otpremnica);
		return "redirect:/otpremnice";
	}
	
	@GetMapping("otpremnica/detalji/{idotpremnice}")
	public String detaljiOtpremnice(Model model, @PathVariable long idotpremnice) {
		Otpremnica otpremnica = otpremnicaService.getOne(idotpremnice);
		List<Roba> robe = robaService.findAll().stream()
				.filter(rb -> rb.getStavkeCenovnika().size() > 0)
				.collect(Collectors.toList());
		List<StavkaOtpremnice> stavkaOtpremnice = stavkaOtpremniceService.findAll().stream()
				.filter(so -> so.getOtpremnica().getId() == idotpremnice)
				.collect(Collectors.toList());
		model.addAttribute("otpremnica", otpremnicaToOtpremnicaDTO.konvertujEntityToDto(otpremnica));
		model.addAttribute("robe", robe);
		model.addAttribute("stavkeOtpremnice", stavkaOtpremnice);
		model.addAttribute("poslovniPartner", poslovniPartnerToPoslovniPartnerDTO.konvertujEntityToDto(otpremnica.getPoslovniPartner()));
		return "otpremnica_detalji";
	}
	
	@GetMapping("/otpremnica/kreirajFakturu/{otpremnicaId}")
	public String kreirajFakturuOdOtpremnice(Model model, @PathVariable long otpremnicaId) {
		PoslovnaGodina poslovnaGodina = poslovnaGodinaService.findByZakljucenaGodinaIsFalseAndObrisanoIsFalse().get(0);
		int poslednjaPoslovnjaGodina = poslovnaGodina.getFakture().size();

		Otpremnica otpremnica = otpremnicaService.getOne(otpremnicaId);
		OtpremnicaDTO otpremnicaDTO = otpremnicaToOtpremnicaDTO.konvertujEntityToDto(otpremnica);
		otpremnicaService.kreirajFakturuOdOtpremnice(otpremnicaDTO, poslednjaPoslovnjaGodina);
		return "redirect:/otpremnice";
	}

}
