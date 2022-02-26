package com.poslovna.Poslovna.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.poslovna.Poslovna.domain.Faktura;
import com.poslovna.Poslovna.domain.Narudzbenica.TipNarudzbenice;
import com.poslovna.Poslovna.domain.Otpremnica;
import com.poslovna.Poslovna.domain.PoslovnaGodina;
import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.domain.StavkaNarudzbenice;

public class NarudzbenicaDTO {
	
    private long id;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datumNarudzbenice;
	
    private long brojNarudzbenice;
	
	private TipNarudzbenice tipNarudzbenice;
	
	private PoslovnaGodina poslovnaGodina;
	
	private PoslovniPartner poslovniPartner;
	
	private Preduzece preduzece;
	
	private Set<StavkaNarudzbenice> stavkeNarudzbenice = new HashSet<>();

	private Set<Otpremnica> otpremnice = new HashSet<>();

	private Set<Faktura> fakture = new HashSet<>();

	private boolean obrisano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatumNarudzbenice() {
		return datumNarudzbenice;
	}

	public void setDatumNarudzbenice(Date datumNarudzbenice) {
		this.datumNarudzbenice = datumNarudzbenice;
	}

	public long getBrojNarudzbenice() {
		return brojNarudzbenice;
	}

	public void setBrojNarudzbenice(long brojNarudzbenice) {
		this.brojNarudzbenice = brojNarudzbenice;
	}

	public TipNarudzbenice getTipNarudzbenice() {
		return tipNarudzbenice;
	}

	public void setTipNarudzbenice(TipNarudzbenice tipNarudzbenice) {
		this.tipNarudzbenice = tipNarudzbenice;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Set<StavkaNarudzbenice> getStavkeNarudzbenice() {
		return stavkeNarudzbenice;
	}

	public void setStavkeNarudzbenice(Set<StavkaNarudzbenice> stavkeNarudzbenice) {
		this.stavkeNarudzbenice = stavkeNarudzbenice;
	}

	public Set<Otpremnica> getOtpremnice() {
		return otpremnice;
	}

	public void setOtpremnice(Set<Otpremnica> otpremnice) {
		this.otpremnice = otpremnice;
	}

	public Set<Faktura> getFakture() {
		return fakture;
	}

	public void setFakture(Set<Faktura> fakture) {
		this.fakture = fakture;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public NarudzbenicaDTO(long id, Date datumNarudzbenice, long brojNarudzbenice, TipNarudzbenice tipNarudzbenice,
			PoslovnaGodina poslovnaGodina, PoslovniPartner poslovniPartner, Preduzece preduzece,
			Set<StavkaNarudzbenice> stavkeNarudzbenice, Set<Otpremnica> otpremnice, Set<Faktura> fakture,
			boolean obrisano) {
		super();
		this.id = id;
		this.datumNarudzbenice = datumNarudzbenice;
		this.brojNarudzbenice = brojNarudzbenice;
		this.tipNarudzbenice = tipNarudzbenice;
		this.poslovnaGodina = poslovnaGodina;
		this.poslovniPartner = poslovniPartner;
		this.preduzece = preduzece;
		this.stavkeNarudzbenice = stavkeNarudzbenice;
		this.otpremnice = otpremnice;
		this.fakture = fakture;
		this.obrisano = obrisano;
	}

	public NarudzbenicaDTO() {
		super();
	}
	
	

}
