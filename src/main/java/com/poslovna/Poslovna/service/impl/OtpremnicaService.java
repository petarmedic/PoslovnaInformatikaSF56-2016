package com.poslovna.Poslovna.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.Cenovnik;
import com.poslovna.Poslovna.domain.Faktura;
import com.poslovna.Poslovna.domain.Narudzbenica;
import com.poslovna.Poslovna.domain.Otpremnica;
import com.poslovna.Poslovna.domain.StavkaCenovnika;
import com.poslovna.Poslovna.domain.StavkaFakture;
import com.poslovna.Poslovna.domain.StavkaNarudzbenice;
import com.poslovna.Poslovna.domain.StavkaOtpremnice;
import com.poslovna.Poslovna.domain.StopaPdv;
import com.poslovna.Poslovna.dto.OtpremnicaDTO;
import com.poslovna.Poslovna.mapper.OtpremnicaDTOToOtpremnica;
import com.poslovna.Poslovna.repository.OtpremnicaRepository;
import com.poslovna.Poslovna.service.ICenovnikService;
import com.poslovna.Poslovna.service.IFakturaService;
import com.poslovna.Poslovna.service.INarudzbenicaService;
import com.poslovna.Poslovna.service.IOtpremnicaService;

@Service
public class OtpremnicaService implements IOtpremnicaService {
	
	@Autowired
	OtpremnicaRepository otpremnicaRepository;
	
	@Autowired
	INarudzbenicaService narudzbenicaService;
	
	@Autowired
	ICenovnikService cenovnikService;
	
	@Autowired
	IFakturaService fakturaService;
	
	@Autowired
	OtpremnicaDTOToOtpremnica otpremnicaDTOToOtpremnica;
	
	@Override
	@Transactional(readOnly = true)
	public List<Otpremnica> findAll() {
		return otpremnicaRepository.findAllOtpremnice();
	}

	@Override
	@Transactional(readOnly = false)
	public void save(Otpremnica otpremnica) {
		otpremnicaRepository.save(otpremnica);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Otpremnica getOne(long idotpremnice) {
		return otpremnicaRepository.getOne(idotpremnice);
	}

	
	@Override
	@Transactional
	public void update(Otpremnica otpremnica) {
          double ukupanIznos = 0;
		
		for(StavkaOtpremnice so : otpremnica.getStavkeOtpremnice()) {
			if(!so.isObrisano()) {
				ukupanIznos += so.getUkupanIznos();
			}
		}
		otpremnica.setRacunOtpremnice(ukupanIznos);
		save(otpremnica);
		
	}
	

	@Override
	@Transactional
	public void kreirajFakturuOdOtpremnice(OtpremnicaDTO otpremnicaDTO, int brojFakture) {
		Otpremnica otpremnica = otpremnicaDTOToOtpremnica.konvertujDtoToEntity(otpremnicaDTO);
		otpremnica.setObrisano(true);
    	save(otpremnica);


        Faktura faktura = new Faktura();
        faktura.setBrojFakture(brojFakture + 1);
        faktura.setDatumFakture(new Date());
        faktura.setDatumValute(new Date());
        faktura.setPlaceno(true);
        faktura.setVrstaFakture(false);
        faktura.setPreduzece(otpremnica.getPreduzece());
        faktura.setPoslovnaGodina(otpremnica.getPoslovnaGodina());
        faktura.setPoslovniPartner(otpremnica.getPoslovniPartner());
        faktura.setOtpremnica(otpremnica);
        
        
        Set<StavkaOtpremnice> stavkeOtpremnice = otpremnica.getStavkeOtpremnice();
      
        Set<StavkaFakture> stavke = new HashSet<>(); 
        
        for(StavkaOtpremnice so : stavkeOtpremnice) {
        	Set<StopaPdv> stopePDva = so.getRoba().getGrupaRobe().getPdv().getStopePdv();
        	StopaPdv stopaPdv = stopePDva.stream().filter(sp -> !sp.isObrisano()).findFirst().get();
   
    			StavkaFakture stavkaFakture = new StavkaFakture();
    			stavkaFakture.setIznosPDV(so.getUkupanIznos()* (stopaPdv.getProcenat() / 100));
    			stavkaFakture.setProcenatPDV(stopaPdv.getProcenat());
    			stavkaFakture.setCena(so.getCena());
    			stavkaFakture.setKolicina(so.getKolicina());
    			stavkaFakture.setOsnovicaPDV(so.getUkupanIznos());
    			stavkaFakture.setRabat(0);
    			stavkaFakture.setUkupanIznos(so.getUkupanIznos() * (1+(stopaPdv.getProcenat() / 100)));
    			stavkaFakture.setObrisano(false);
    			stavkaFakture.setRoba(so.getRoba());
    			
    			stavkaFakture.setFaktura(faktura);

                stavke.add(stavkaFakture);
        }

        faktura.setStavkeFakture(stavke);
        fakturaService.update(faktura);
		
	}
	
	@Override
	@Transactional
	public void kreirajOtpremnicuOdNaruzbenice(Narudzbenica narudzbenica) {
		 List<Otpremnica> listaOtpremnica = otpremnicaRepository.findAll();
	        
	        narudzbenica.setObrisano(true);
	        narudzbenicaService.save(narudzbenica);

	        Otpremnica otpremnica = new Otpremnica();
	        otpremnica.setBrojOtpremnice(listaOtpremnica.size() + 1);
	        otpremnica.setDatumOtpremnice(new Date());
	        otpremnica.setPreduzece(narudzbenica.getPreduzece());
	        otpremnica.setPoslovnaGodina(narudzbenica.getPoslovnaGodina());
	        otpremnica.setPoslovniPartner(narudzbenica.getPoslovniPartner());
	        otpremnica.setTipOtpremnice(false);
	        otpremnica.setObrisano(false);
	        otpremnica.setNarudzbenica(narudzbenica);
	   
	        
	        List<Cenovnik> cenovnik = cenovnikService.findAll().stream()
					.filter(c -> c.getPoslovniPartner().getId() == otpremnica.getPoslovniPartner().getId())
					.collect(Collectors.toList());
	        
	        
	        Set<StavkaNarudzbenice> stavkeNarudzbenice = narudzbenica.getStavkeNarudzbenice();
	        Set<StavkaOtpremnice> stavkeOtpremnice = new HashSet<>();
	        List<StavkaCenovnika> stavkeCenovnika = new ArrayList<StavkaCenovnika>();
	        
	        for (Cenovnik c : cenovnik) {
	        	for(StavkaCenovnika s : c.getCene()) {
	        		stavkeCenovnika.add(s);
	        	}
			}

	        for (StavkaNarudzbenice stavkaNarudzbenice : stavkeNarudzbenice) {
	        	
	        	
	        	for(StavkaCenovnika sc : stavkeCenovnika) {
	        		
	        		if(sc.getRoba().getId() == stavkaNarudzbenice.getRoba().getId()) {
	        	
	                    StavkaOtpremnice stavkaOtpremnice = new StavkaOtpremnice();
	                    stavkaOtpremnice.setJedinicaMere(stavkaNarudzbenice.getJedinicaMere());
	                    stavkaOtpremnice.setKolicina(stavkaNarudzbenice.getKolicina());
	                    stavkaOtpremnice.setRoba(stavkaNarudzbenice.getRoba());
	                    stavkaOtpremnice.setCena(sc.getCena());
	                    stavkaOtpremnice.setUkupanIznos(stavkaNarudzbenice.getKolicina() * sc.getCena());
	                    stavkaOtpremnice.setOtpremnica(otpremnica);
	                    stavkaOtpremnice.setObrisano(false);
	                    stavkaOtpremnice.setOpis(stavkaNarudzbenice.getOpis());

	                    stavkeOtpremnice.add(stavkaOtpremnice);
	        			}
	        		}
	        }

	        otpremnica.setStavkeOtpremnice(stavkeOtpremnice);
	        update(otpremnica);
		
	}


}