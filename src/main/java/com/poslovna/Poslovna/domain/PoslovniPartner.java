package com.poslovna.Poslovna.domain;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Where(clause = "obrisano='false'")
public class PoslovniPartner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "naziv_poslovnog_partnera")
	private String nazivPoslovnogPartnera;

	@Column(name = "tip_poslovnog_partnera")
	private TipPoslovnogPartnera tipPoslovnogPartnera; 

	private String PIB;

	private String adresa;

	@Column(name = "tekuci_racun")
	private String tekuciRacun;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "preduzece_id")
	private Preduzece preduzece;

	@OneToMany(mappedBy = "poslovniPartner", cascade = CascadeType.ALL)
	private Set<Narudzbenica> narudzbenice = new HashSet<>();

	@OneToMany(mappedBy = "poslovniPartner", cascade = CascadeType.ALL)
	private Set<Otpremnica> otpremnice = new HashSet<>();

	@OneToMany(mappedBy = "poslovniPartner", cascade = CascadeType.ALL)
	private Set<Faktura> fakture = new HashSet<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mesto_id")
	private Mesto mesto;

	@OneToMany(mappedBy = "poslovniPartner", cascade = CascadeType.ALL)
	private Set<Cenovnik> cenovnici = new HashSet<>();

	private boolean obrisano;
	
	
	public enum TipPoslovnogPartnera {
		KUPAC(0), DOBAVLJAC(1);

		private int value;
		private static Map map = new HashMap<>();

		private TipPoslovnogPartnera(int value) {
			this.value = value;
		}

		static {
			for (TipPoslovnogPartnera tipPoslovnogPartnera : TipPoslovnogPartnera.values()) {
				map.put(tipPoslovnogPartnera.value, tipPoslovnogPartnera);
			}
		}

		public static TipPoslovnogPartnera valueOf(int tip) {
			return (TipPoslovnogPartnera) map.get(tip);
		}

		public int getValue() {
			return value;
		}

		public static Map getMap() {
			return map;
		}

		public static void setMap(Map map) {
			TipPoslovnogPartnera.map = map;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNazivPoslovnogPartnera() {
		return nazivPoslovnogPartnera;
	}


	public void setNazivPoslovnogPartnera(String nazivPoslovnogPartnera) {
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
	}


	public TipPoslovnogPartnera getTipPoslovnogPartnera() {
		return tipPoslovnogPartnera;
	}


	public void setTipPoslovnogPartnera(TipPoslovnogPartnera tipPoslovnogPartnera) {
		this.tipPoslovnogPartnera = tipPoslovnogPartnera;
	}


	public String getPIB() {
		return PIB;
	}


	public void setPIB(String pIB) {
		PIB = pIB;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getTekuciRacun() {
		return tekuciRacun;
	}


	public void setTekuciRacun(String tekuciRacun) {
		this.tekuciRacun = tekuciRacun;
	}


	public Preduzece getPreduzece() {
		return preduzece;
	}


	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
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


	public Mesto getMesto() {
		return mesto;
	}


	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}


	public Set<Cenovnik> getCenovnici() {
		return cenovnici;
	}


	public void setCenovnici(Set<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}


	public boolean isObrisano() {
		return obrisano;
	}


	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}


	public PoslovniPartner(long id, String nazivPoslovnogPartnera, TipPoslovnogPartnera tipPoslovnogPartnera,
			String pIB, String adresa, String tekuciRacun, Preduzece preduzece, Set<Narudzbenica> narudzbenice,
			Set<Otpremnica> otpremnice, Set<Faktura> fakture, Mesto mesto, Set<Cenovnik> cenovnici, boolean obrisano) {
		super();
		this.id = id;
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
		this.tipPoslovnogPartnera = tipPoslovnogPartnera;
		PIB = pIB;
		this.adresa = adresa;
		this.tekuciRacun = tekuciRacun;
		this.preduzece = preduzece;
		this.narudzbenice = narudzbenice;
		this.otpremnice = otpremnice;
		this.fakture = fakture;
		this.mesto = mesto;
		this.cenovnici = cenovnici;
		this.obrisano = obrisano;
	}


	public PoslovniPartner() {
		super();
	}


	
}
