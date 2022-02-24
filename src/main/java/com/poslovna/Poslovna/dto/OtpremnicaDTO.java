package com.poslovna.Poslovna.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.poslovna.Poslovna.domain.Faktura;
import com.poslovna.Poslovna.domain.PoslovnaGodina;
import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.domain.StavkaOtpremnice;

public class OtpremnicaDTO {
	
	private long id;

	private long brojOtpremnice;

	private Date datumOtpremnice;

	private boolean tipOtpremnice;

	private double racunOtpremnice;

	
	private PoslovnaGodina poslovnaGodina;

	private PoslovniPartner poslovniPartner;

	private Preduzece preduzece;

	
	private Set<StavkaOtpremnice> stavkeOtpremnice = new HashSet<>();

	private Set<Faktura> fakture = new HashSet<>();

	private boolean obrisano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBrojOtpremnice() {
		return brojOtpremnice;
	}

	public void setBrojOtpremnice(long brojOtpremnice) {
		this.brojOtpremnice = brojOtpremnice;
	}

	public Date getDatumOtpremnice() {
		return datumOtpremnice;
	}

	public void setDatumOtpremnice(Date datumOtpremnice) {
		this.datumOtpremnice = datumOtpremnice;
	}

	public boolean isTipOtpremnice() {
		return tipOtpremnice;
	}

	public void setTipOtpremnice(boolean tipOtpremnice) {
		this.tipOtpremnice = tipOtpremnice;
	}

	public double getRacunOtpremnice() {
		return racunOtpremnice;
	}

	public void setRacunOtpremnice(double racunOtpremnice) {
		this.racunOtpremnice = racunOtpremnice;
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

	public Set<StavkaOtpremnice> getStavkeOtpremnice() {
		return stavkeOtpremnice;
	}

	public void setStavkeOtpremnice(Set<StavkaOtpremnice> stavkeOtpremnice) {
		this.stavkeOtpremnice = stavkeOtpremnice;
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

	public OtpremnicaDTO(long id, long brojOtpremnice, Date datumOtpremnice, boolean tipOtpremnice,
			double racunOtpremnice, PoslovnaGodina poslovnaGodina, PoslovniPartner poslovniPartner, Preduzece preduzece,
			Set<StavkaOtpremnice> stavkeOtpremnice, Set<Faktura> fakture, boolean obrisano) {
		super();
		this.id = id;
		this.brojOtpremnice = brojOtpremnice;
		this.datumOtpremnice = datumOtpremnice;
		this.tipOtpremnice = tipOtpremnice;
		this.racunOtpremnice = racunOtpremnice;
		this.poslovnaGodina = poslovnaGodina;
		this.poslovniPartner = poslovniPartner;
		this.preduzece = preduzece;
		this.stavkeOtpremnice = stavkeOtpremnice;
		this.fakture = fakture;
		this.obrisano = obrisano;
	}

	public OtpremnicaDTO() {
		super();
	}
	
	
}
