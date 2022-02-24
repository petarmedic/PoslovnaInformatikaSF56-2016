package com.poslovna.Poslovna.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StavkaCenovnika {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private float cena;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cenovnik_id")
	private Cenovnik cenovnik;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roba_id")
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

	public StavkaCenovnika(long id, float cena, Cenovnik cenovnik, Roba roba, boolean obrisano) {
		super();
		this.id = id;
		this.cena = cena;
		this.cenovnik = cenovnik;
		this.roba = roba;
		this.obrisano = obrisano;
	}

	public StavkaCenovnika() {
		super();
	}

}
