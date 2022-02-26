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
import org.springframework.web.bind.annotation.RequestParam;

import com.poslovna.Poslovna.domain.Narudzbenica;
import com.poslovna.Poslovna.domain.Narudzbenica.TipNarudzbenice;
import com.poslovna.Poslovna.domain.PoslovnaGodina;
import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.domain.PoslovniPartner.TipPoslovnogPartnera;
import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.domain.Roba;
import com.poslovna.Poslovna.domain.StavkaNarudzbenice;
import com.poslovna.Poslovna.dto.NarudzbenicaDTO;
import com.poslovna.Poslovna.mapper.NarudzbenicaDTOToNarudzbenica;
import com.poslovna.Poslovna.mapper.NarudzbenicaToNarudzbenicaDTO;
import com.poslovna.Poslovna.mapper.PoslovniPartnerToPoslovniPartnerDTO;
import com.poslovna.Poslovna.mapper.RobaToRobaDTO;
import com.poslovna.Poslovna.service.INarudzbenicaService;
import com.poslovna.Poslovna.service.IOtpremnicaService;
import com.poslovna.Poslovna.service.IPoslovnaGodinaService;
import com.poslovna.Poslovna.service.IPoslovniPartnerService;
import com.poslovna.Poslovna.service.IPreduzeceService;
import com.poslovna.Poslovna.service.IRobaService;
import com.poslovna.Poslovna.service.IStavkaNarudzbeniceService;

@Controller
public class NarudzbenicaController {
	
	@Autowired
	IPoslovnaGodinaService poslovnaGodinaService;
	
	@Autowired
	INarudzbenicaService narudzbenicaService;
	
	@Autowired
	IStavkaNarudzbeniceService stavkaNarudzbeniceService;
	
	@Autowired
	IOtpremnicaService otpremnicaService;
	
	@Autowired
	IPoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	IPreduzeceService preduzeceService;
	
	@Autowired
	IRobaService robaService;
	
	@Autowired
	NarudzbenicaDTOToNarudzbenica narudzbenicaDTOToNarudzbenica;
	
	@Autowired
	NarudzbenicaToNarudzbenicaDTO narudzbenicaToNarudzbenicaDTO;
	
	@Autowired
	PoslovniPartnerToPoslovniPartnerDTO poslovniPartnerToPoslovniPartnerDTO;
	
	@Autowired
	RobaToRobaDTO robaToRobaDTO;
	
	@GetMapping("/narudzbenice")
	public String getAll(@RequestParam(value = "tipNarudzbenice", defaultValue = "3") int tip, Model model) {
		List<Narudzbenica> narudzbenice = narudzbenicaService.findAll();
		tip = Integer.valueOf(tip);
		if (tip == 3) {
			List<NarudzbenicaDTO> narudzbeniceDTO = narudzbenicaToNarudzbenicaDTO.konvertujEntityToDto(narudzbenice);
			model.addAttribute("tipNarudzbenice", tip);
			model.addAttribute("narudzbenice", narudzbeniceDTO);

			return "narudzbenice";
		}

		int finalTip = tip;
		List<Narudzbenica> naruzbenicaFilter = narudzbenice.stream()
				.filter(n -> n.getTipNarudzbenice() == TipNarudzbenice.valueOf(finalTip))
				.collect(Collectors.toList());
		model.addAttribute("tipNarudzbenice", finalTip);
		model.addAttribute("narudzbeniceFilter", narudzbenicaToNarudzbenicaDTO.konvertujEntityToDto(naruzbenicaFilter));

		return "narudzbenice";

	}
	
	@GetMapping("narudzbenica/dodavanje/{tipNarudzbenice}")
	public String dodajNarudzbenicu(Model model, @PathVariable int tipNarudzbenice) {
		List<PoslovniPartner> listaPoslovniPartneri = poslovniPartnerService.findAll().stream()
				.filter(pp -> pp.getTipPoslovnogPartnera() == TipPoslovnogPartnera.valueOf(tipNarudzbenice))
				.collect(Collectors.toList());
		model.addAttribute("tipNarudzbenice", tipNarudzbenice);
		model.addAttribute("listaPoslovnihPartnera", poslovniPartnerToPoslovniPartnerDTO.konvertujEntityToDto(listaPoslovniPartneri));
		model.addAttribute("narudzbenica", new NarudzbenicaDTO());

		return "dodajNarudzbenicu";
	}
	
	@PostMapping("narudzbenica/dodavanje")
	public String dodajNarudzbenicu(NarudzbenicaDTO narudzbenicaDTO) {
		List<Preduzece> preduzeca = preduzeceService.findAll();
	//	PoslovniPartner partner = poslovniPartnerService.findOne(narudzbenicaDTO.getTipNarudzbenice());
		PoslovnaGodina poslednjaPoslovnaGodina = poslovnaGodinaService.findByZakljucenaGodinaIsFalseAndObrisanoIsFalse().get(0);
		Narudzbenica narudzbenica = narudzbenicaDTOToNarudzbenica.konvertujDtoToEntity(narudzbenicaDTO);
		narudzbenica.setPreduzece(preduzeca.get(0));
		narudzbenica.setDatumNarudzbenice(new Date());
		narudzbenica.setObrisano(false);
		narudzbenica.setPoslovnaGodina(poslednjaPoslovnaGodina);
		narudzbenica.setBrojNarudzbenice(poslednjaPoslovnaGodina.getNarudzbenice().size() + 1);
		int fs = narudzbenicaDTO.getPoslovniPartner().getTipPoslovnogPartnera().getValue();
		narudzbenica.setTipNarudzbenice(TipNarudzbenice.valueOf(narudzbenicaDTO.getPoslovniPartner().getTipPoslovnogPartnera().getValue()));
	//	narudzbenica.setPoslovniPartner(partner);
		//narudzbenica.setTipNarudzbenice(TipNarudzbenice.valueOf(partner.getTipPoslovnogPartnera().getValue()));
        narudzbenicaService.save(narudzbenica);
		return "redirect:/narudzbenice";
	}
	
	@GetMapping("narudzbenica/detalji/{idNarudzbenice}")
	public String detaljiNarudzbenice(Model model, @PathVariable int idNarudzbenice) {
		long re = 5;
		Narudzbenica narudzbenica = narudzbenicaService.getOne(idNarudzbenice);
		List<Roba> robe = robaService.findAll().stream()
				.filter(rb -> rb.getStavkeCenovnika().size() > 0)
				.collect(Collectors.toList());
		List<StavkaNarudzbenice> stavkeNarudzbenice = stavkaNarudzbeniceService.findAll().stream()
				.filter(sn -> sn.getNarudzbenica().getId() == idNarudzbenice)
				.collect(Collectors.toList());
		NarudzbenicaDTO dto = narudzbenicaToNarudzbenicaDTO.konvertujEntityToDto(narudzbenica);
		model.addAttribute("narudzbenica", dto);
		model.addAttribute("robe", robe);
		model.addAttribute("stavkeNarudzbenice", stavkeNarudzbenice);
		model.addAttribute("poslovniPartner", poslovniPartnerToPoslovniPartnerDTO.konvertujEntityToDto(narudzbenica.getPoslovniPartner()));
		return "narudzbenica_detalji";
	}
	
	@GetMapping("/narudzbenica/kreirajOtpremnicu/{idNaruzbenice}")
	public String kreirajOtpremnicuOdNarudzbenice(Model model, @PathVariable long idNaruzbenice) {
		Narudzbenica narudzbenica = narudzbenicaService.getOne(idNaruzbenice);
		otpremnicaService.kreirajOtpremnicuOdNaruzbenice(narudzbenica);
		return "redirect:/narudzbenice";
	}
	
	@GetMapping("/narudzbenica/kreirajFakturu/{idNaruzbenice}")
	public String kreirajFakturuOdNarudzbenice(Model model, @PathVariable long idNaruzbenice) {
		PoslovnaGodina poslovnaGodina = poslovnaGodinaService.findByZakljucenaGodinaIsFalseAndObrisanoIsFalse().get(0);
		int poslednjaPoslovnjaGodina = poslovnaGodina.getFakture().size();

		Narudzbenica narudzbenica = narudzbenicaService.getOne(idNaruzbenice);
		NarudzbenicaDTO narudzbenicaDTO = narudzbenicaToNarudzbenicaDTO.konvertujEntityToDto(narudzbenica);
		narudzbenicaService.kreirajFakturuOdNarudzbenice(narudzbenicaDTO, poslednjaPoslovnjaGodina);
		return "redirect:/narudzbenice";
	}

}
