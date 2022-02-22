package com.poslovna.Poslovna.domain;

import java.util.Date;
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


@Entity
public class Narudzbenica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long brojNarudzbenice;

	private Date datumNarudzbenice;

	@Column(name = "tip_narudzbenice")
	private TipNarudzbenice tipNarudzbenice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poslovna_godina_id")
	private PoslovnaGodina poslovnaGodina;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poslovni_partner_id")
	private PoslovniPartner poslovniPartner;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "preduzece_id")
	private Preduzece preduzece;

	@OneToMany(mappedBy = "narudzbenica", cascade = CascadeType.ALL)
	private Set<StavkaNarudzbenice> stavkeNarudzbenice = new HashSet<>();

	@OneToMany(mappedBy = "narudzbenica", cascade = CascadeType.ALL)
	private Set<Otpremnica> otpremnice = new HashSet<>();

	@OneToMany(mappedBy = "narudzbenica", cascade = CascadeType.MERGE)
	private Set<Faktura> fakture = new HashSet<>();

	private boolean obrisano;
	
	public enum TipNarudzbenice {
		ULAZNA(0), IZLAZNA(1);

		private int value;
		private static Map map = new HashMap<>();

		private TipNarudzbenice(int value) {
			this.value = value;
		}

		static {
			for (TipNarudzbenice tipNarudzbenice : TipNarudzbenice.values()) {
				map.put(tipNarudzbenice.value, tipNarudzbenice);
			}
		}

		public static TipNarudzbenice valueOf(int tip) {
			return (TipNarudzbenice) map.get(tip);
		}

		public int getValue() {
			return value;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBrojNarudzbenice() {
		return brojNarudzbenice;
	}

	public void setBrojNarudzbenice(long brojNarudzbenice) {
		this.brojNarudzbenice = brojNarudzbenice;
	}

	public Date getDatumNarudzbenice() {
		return datumNarudzbenice;
	}

	public void setDatumNarudzbenice(Date datumNarudzbenice) {
		this.datumNarudzbenice = datumNarudzbenice;
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

	public Narudzbenica(long id, long brojNarudzbenice, Date datumNarudzbenice, TipNarudzbenice tipNarudzbenice,
			PoslovnaGodina poslovnaGodina, PoslovniPartner poslovniPartner, Preduzece preduzece,
			Set<StavkaNarudzbenice> stavkeNarudzbenice, Set<Otpremnica> otpremnice, Set<Faktura> fakture,
			boolean obrisano) {
		super();
		this.id = id;
		this.brojNarudzbenice = brojNarudzbenice;
		this.datumNarudzbenice = datumNarudzbenice;
		this.tipNarudzbenice = tipNarudzbenice;
		this.poslovnaGodina = poslovnaGodina;
		this.poslovniPartner = poslovniPartner;
		this.preduzece = preduzece;
		this.stavkeNarudzbenice = stavkeNarudzbenice;
		this.otpremnice = otpremnice;
		this.fakture = fakture;
		this.obrisano = obrisano;
	}

	public Narudzbenica() {
		super();
	}
	
	

}
