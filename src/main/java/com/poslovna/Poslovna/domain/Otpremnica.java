package com.poslovna.Poslovna.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Otpremnica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long brojOtpremnice;

	private Date datumOtpremnice;

	private boolean tipOtpremnice;

	private double racunOtpremnice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poslovna_godina_id")
	private PoslovnaGodina poslovnaGodina;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poslovni_partner_id")
	private PoslovniPartner poslovniPartner;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "preduzece_id")
	private Preduzece preduzece;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "narudzbenica_id")
	private Narudzbenica narudzbenica;

	@OneToMany(mappedBy = "otpremnica", cascade = CascadeType.ALL)
	private Set<StavkaOtpremnice> stavkeOtpremnice = new HashSet<>();

	@OneToMany(mappedBy = "otpremnica", cascade = CascadeType.MERGE)
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

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
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

	public Otpremnica(long id, long brojOtpremnice, Date datumOtpremnice, boolean tipOtpremnice, double racunOtpremnice,
			PoslovnaGodina poslovnaGodina, PoslovniPartner poslovniPartner, Preduzece preduzece,
			Narudzbenica narudzbenica, Set<StavkaOtpremnice> stavkeOtpremnice, Set<Faktura> fakture, boolean obrisano) {
		super();
		this.id = id;
		this.brojOtpremnice = brojOtpremnice;
		this.datumOtpremnice = datumOtpremnice;
		this.tipOtpremnice = tipOtpremnice;
		this.racunOtpremnice = racunOtpremnice;
		this.poslovnaGodina = poslovnaGodina;
		this.poslovniPartner = poslovniPartner;
		this.preduzece = preduzece;
		this.narudzbenica = narudzbenica;
		this.stavkeOtpremnice = stavkeOtpremnice;
		this.fakture = fakture;
		this.obrisano = obrisano;
	}

	public Otpremnica() {
		super();
	}

	
}
