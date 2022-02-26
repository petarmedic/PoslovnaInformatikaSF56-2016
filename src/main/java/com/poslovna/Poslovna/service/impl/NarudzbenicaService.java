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
import com.poslovna.Poslovna.domain.PoslovniPartner.TipPoslovnogPartnera;
import com.poslovna.Poslovna.domain.StavkaCenovnika;
import com.poslovna.Poslovna.domain.StavkaFakture;
import com.poslovna.Poslovna.domain.StavkaNarudzbenice;
import com.poslovna.Poslovna.domain.StopaPdv;
import com.poslovna.Poslovna.dto.NarudzbenicaDTO;
import com.poslovna.Poslovna.mapper.NarudzbenicaDTOToNarudzbenica;
import com.poslovna.Poslovna.repository.NarudzbenicaRepository;
import com.poslovna.Poslovna.service.ICenovnikService;
import com.poslovna.Poslovna.service.IFakturaService;
import com.poslovna.Poslovna.service.INarudzbenicaService;
import com.poslovna.Poslovna.service.IStavkeFaktureService;

@Service
public class NarudzbenicaService implements INarudzbenicaService {

	@Autowired
	NarudzbenicaRepository narudzbenicaRepository;
	
	@Autowired
	ICenovnikService cenovnikService;
	
	@Autowired
	IFakturaService fakturaService;
	
	@Autowired
	IStavkeFaktureService stavkeFakture;
	
	@Autowired
	NarudzbenicaDTOToNarudzbenica narudzbenicaDTOToNarudzbenica;
	
	@Override
	@Transactional(readOnly = true)
	public List<Narudzbenica> findAll() {
		return narudzbenicaRepository.findAllNarudzbenice();
	}

	@Override
	@Transactional(readOnly = true)
	public Narudzbenica getOne(long id) {
		return narudzbenicaRepository.getOne(id);
	}

	@Override
	public void save(Narudzbenica narudzbenica) {
		narudzbenicaRepository.save(narudzbenica);
		
	}

	@Override
	@Transactional
	public void kreirajFakturuOdNarudzbenice(NarudzbenicaDTO narudzbenicaDTO, int poslednjaPoslovnjaGodina) {
		Narudzbenica narudzbenica = narudzbenicaDTOToNarudzbenica.konvertujDtoToEntity(narudzbenicaDTO); 
		narudzbenica.setObrisano(true);
    	save(narudzbenica);

        Faktura faktura = new Faktura();
        faktura.setBrojFakture(poslednjaPoslovnjaGodina + 1);
        faktura.setDatumFakture(new Date());
        faktura.setDatumValute(new Date());
        faktura.setPlaceno(true);
        if(narudzbenica.getPoslovniPartner().getTipPoslovnogPartnera() == TipPoslovnogPartnera.KUPAC) {
           faktura.setVrstaFakture(false);
        }
        else {
            faktura.setVrstaFakture(true);
        }
        faktura.setPreduzece(narudzbenica.getPreduzece());
        faktura.setPoslovnaGodina(narudzbenica.getPoslovnaGodina());
        faktura.setPoslovniPartner(narudzbenica.getPoslovniPartner());
        faktura.setNarudzbenica(narudzbenica);
      
        
        Set<StavkaNarudzbenice> stavkeNarudzbenice = narudzbenica.getStavkeNarudzbenice();
        
        
        List<Cenovnik> cenovnici = new ArrayList<Cenovnik>();
        
        	List<Cenovnik>cenovniciList = cenovnikService.findAll().stream()
    				.filter(cen -> cen.getPoslovniPartner().getId() == narudzbenica.getPoslovniPartner().getId())
    				.collect(Collectors.toList());
        	
        	for (Cenovnik cenovnik : cenovniciList) {
				cenovnici.add(cenovnik);
			}
      
        
    //    List<Cjenovnik> cjenovnici = cjenovnikService.findAllByPreduzeceId(narudzbenica.getPreduzece().getId());
        
        List<StavkaCenovnika> stavkeCenovnika = new ArrayList<StavkaCenovnika>();
        
        for (Cenovnik c : cenovnici) {
        	for(StavkaCenovnika s : c.getCene()) {
        		stavkeCenovnika.add(s);
        	}
		}


        Set<StavkaFakture> nadjeneStavke = new HashSet<>();

        for (StavkaNarudzbenice sn : stavkeNarudzbenice) {
        	        	
        	for(StavkaCenovnika sc : stavkeCenovnika) {
        		
        		if(sc.getRoba().getId() == sn.getRoba().getId()) {
        		Set<StopaPdv> stopePDva = sn.getRoba().getGrupaRobe().getPdv().getStopePdv();
        		StopaPdv stopaPdv = stopePDva.stream().filter(sp -> !sp.isObrisano()).findFirst().get();
        				
                    StavkaFakture novaStavkaFakture = new StavkaFakture();
                    novaStavkaFakture.setIznosPDV(sc.getCena() * sn.getKolicina() * (stopaPdv.getProcenat() / 100));
                    novaStavkaFakture.setUkupanIznos(sc.getCena() * sn.getKolicina() * (1+(stopaPdv.getProcenat() / 100)));
                    novaStavkaFakture.setCena(sc.getCena());
                    novaStavkaFakture.setKolicina(sn.getKolicina());
                    novaStavkaFakture.setOsnovicaPDV(sc.getCena() * sn.getKolicina());
                    novaStavkaFakture.setObrisano(false);
                    novaStavkaFakture.setRabat(0);
                    novaStavkaFakture.setRoba(sn.getRoba());
                    novaStavkaFakture.setProcenatPDV(stopaPdv.getProcenat());
                    novaStavkaFakture.setFaktura(faktura);
                    nadjeneStavke.add(novaStavkaFakture);
        		}
        	}
        }

        faktura.setStavkeFakture(nadjeneStavke);
        fakturaService.update(faktura);
		
	}

}
