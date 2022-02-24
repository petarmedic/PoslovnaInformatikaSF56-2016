package com.poslovna.Poslovna.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poslovna.Poslovna.domain.Faktura;
import com.poslovna.Poslovna.domain.Otpremnica;
import com.poslovna.Poslovna.domain.StavkaFakture;
import com.poslovna.Poslovna.domain.StavkaOtpremnice;
import com.poslovna.Poslovna.domain.StopaPdv;
import com.poslovna.Poslovna.dto.OtpremnicaDTO;
import com.poslovna.Poslovna.mapper.OtpremnicaDTOToOtpremnica;
import com.poslovna.Poslovna.repository.OtpremnicaRepository;
import com.poslovna.Poslovna.service.ICenovnikService;
import com.poslovna.Poslovna.service.IFakturaService;
import com.poslovna.Poslovna.service.IOtpremnicaService;

@Service
public class OtpremnicaService implements IOtpremnicaService {
	
	@Autowired
	OtpremnicaRepository otpremnicaRepository;
	
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


}