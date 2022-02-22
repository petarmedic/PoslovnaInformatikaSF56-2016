package com.poslovna.Poslovna.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;

@Entity
public class Preduzece {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "naziv_preduzeca")
	private String nazivPreduzeca;

	@Column(name = "pib")
	private String PIB;

	@Column(name = "tekuci_racun")
	private String tekuciRacun;

	@Column(name = "email")
	private String emailAdresa;

	private String adresa;

	private String telefon;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mesto_id")
	private Mesto mesto;

	@OneToMany(mappedBy = "preduzece", cascade = CascadeType.ALL)
	private Set<PoslovniPartner> poslovniPartneri = new HashSet<>();

	@OneToMany(mappedBy = "preduzece", cascade = CascadeType.ALL)
	private Set<Narudzbenica> narudzbenice = new HashSet<>();

	@OneToMany(mappedBy = "preduzece", cascade = CascadeType.ALL)
	private Set<Otpremnica> otpremnice = new HashSet<>();

	@OneToMany(mappedBy = "preduzece", cascade = CascadeType.ALL)
	private Set<Faktura> fakture = new HashSet<>();

	@OneToMany(mappedBy = "preduzece", cascade = CascadeType.ALL)
	private Set<Cenovnik> cenovnici = new HashSet<>();

	@OneToMany(mappedBy = "preduzece", cascade = CascadeType.ALL)
	private Set<GrupaRobe> grupeRobe = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}

	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}

	public String getPIB() {
		return PIB;
	}

	public void setPIB(String pIB) {
		PIB = pIB;
	}

	public String getTekuciRacun() {
		return tekuciRacun;
	}

	public void setTekuciRacun(String tekuciRacun) {
		this.tekuciRacun = tekuciRacun;
	}

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	public Set<PoslovniPartner> getPoslovniPartneri() {
		return poslovniPartneri;
	}

	public void setPoslovniPartneri(Set<PoslovniPartner> poslovniPartneri) {
		this.poslovniPartneri = poslovniPartneri;
	}

	public Set<Narudzbenica> getNarudzbenice() {
		return narudzbenice;
	}

	public void setNarudzbenice(Set<Narudzbenica> narudzbenice) {
		this.narudzbenice = narudzbenice;
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

	public Set<Cenovnik> getCenovnici() {
		return cenovnici;
	}

	public void setCenovnici(Set<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}

	public Set<GrupaRobe> getGrupeRobe() {
		return grupeRobe;
	}

	public void setGrupeRobe(Set<GrupaRobe> grupeRobe) {
		this.grupeRobe = grupeRobe;
	}

	public Preduzece(long id, String nazivPreduzeca, String pIB, String tekuciRacun, String emailAdresa, String adresa,
			String telefon, Mesto mesto, Set<PoslovniPartner> poslovniPartneri, Set<Narudzbenica> narudzbenice,
			Set<Otpremnica> otpremnice, Set<Faktura> fakture, Set<Cenovnik> cenovnici, Set<GrupaRobe> grupeRobe) {
		super();
		this.id = id;
		this.nazivPreduzeca = nazivPreduzeca;
		PIB = pIB;
		this.tekuciRacun = tekuciRacun;
		this.emailAdresa = emailAdresa;
		this.adresa = adresa;
		this.telefon = telefon;
		this.mesto = mesto;
		this.poslovniPartneri = poslovniPartneri;
		this.narudzbenice = narudzbenice;
		this.otpremnice = otpremnice;
		this.fakture = fakture;
		this.cenovnici = cenovnici;
		this.grupeRobe = grupeRobe;
	}

	public Preduzece() {
		super();
	}

	
	
}
