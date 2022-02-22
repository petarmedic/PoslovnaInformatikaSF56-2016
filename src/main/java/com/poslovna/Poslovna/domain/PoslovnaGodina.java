package com.poslovna.Poslovna.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PoslovnaGodina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int godinaPoslovanja;

	private boolean zakljucenaGodina;

	@OneToMany(mappedBy = "poslovnaGodina", cascade = CascadeType.ALL)
	private Set<Narudzbenica> narudzbenice = new HashSet<>();

	@OneToMany(mappedBy = "poslovnaGodina", cascade = CascadeType.ALL)
	private Set<Otpremnica> otpremnice = new HashSet<>();

	@OneToMany(mappedBy = "poslovnaGodina", cascade = CascadeType.ALL)
	private Set<Faktura> fakture = new HashSet<>();

	private boolean obrisano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getGodinaPoslovanja() {
		return godinaPoslovanja;
	}

	public void setGodinaPoslovanja(int godinaPoslovanja) {
		this.godinaPoslovanja = godinaPoslovanja;
	}

	public boolean isZakljucenaGodina() {
		return zakljucenaGodina;
	}

	public void setZakljucenaGodina(boolean zakljucenaGodina) {
		this.zakljucenaGodina = zakljucenaGodina;
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

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public PoslovnaGodina(long id, int godinaPoslovanja, boolean zakljucenaGodina, Set<Narudzbenica> narudzbenice,
			Set<Otpremnica> otpremnice, Set<Faktura> fakture, boolean obrisano) {
		super();
		this.id = id;
		this.godinaPoslovanja = godinaPoslovanja;
		this.zakljucenaGodina = zakljucenaGodina;
		this.narudzbenice = narudzbenice;
		this.otpremnice = otpremnice;
		this.fakture = fakture;
		this.obrisano = obrisano;
	}

	public PoslovnaGodina() {
		super();
	}

	
}
