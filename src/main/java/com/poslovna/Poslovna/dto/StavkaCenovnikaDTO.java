package com.poslovna.Poslovna.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poslovna.Poslovna.domain.Cenovnik;
import com.poslovna.Poslovna.domain.Roba;


public class StavkaCenovnikaDTO {

	private long id;

	private float cena;

	@JsonIgnore
	private Cenovnik cenovnik;

	@JsonIgnore
	private Roba roba;

	private boolean obrisano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}

	public Roba getRoba() {
		return roba;
	}

	public void setRoba(Roba roba) {
		this.roba = roba;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public StavkaCenovnikaDTO(long id, float cena, Cenovnik cenovnik, Roba roba, boolean obrisano) {
		super();
		this.id = id;
		this.cena = cena;
		this.cenovnik = cenovnik;
		this.roba = roba;
		this.obrisano = obrisano;
	}

	public StavkaCenovnikaDTO() {
		super();
	}

	
}
