package com.poslovna.Poslovna.dto;

import java.util.HashSet;
import java.util.Set;

import com.poslovna.Poslovna.domain.Faktura;
import com.poslovna.Poslovna.domain.Otpremnica;

public class PoslovnaGodinaDTO {
	
	private long id;

	private int godinaPoslovanja;

	private boolean zakljucenaGodina;

	private Set<Otpremnica> otpremnice = new HashSet<>();

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

	public PoslovnaGodinaDTO(long id, int godinaPoslovanja, boolean zakljucenaGodina, Set<Otpremnica> otpremnice,
			Set<Faktura> fakture, boolean obrisano) {
		super();
		this.id = id;
		this.godinaPoslovanja = godinaPoslovanja;
		this.zakljucenaGodina = zakljucenaGodina;
		this.otpremnice = otpremnice;
		this.fakture = fakture;
		this.obrisano = obrisano;
	}

	public PoslovnaGodinaDTO() {
		super();
	}
	
	
}
