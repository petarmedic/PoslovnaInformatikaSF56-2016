package com.poslovna.Poslovna.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StavkaNarudzbenice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "jedinica_mere")
	private String jedinicaMere;

	private int kolicina;

	private String opis;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "narudzbenica_id")
	private Narudzbenica narudzbenica;

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

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
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

	public StavkaNarudzbenice(long id, String jedinicaMere, int kolicina, String opis, Narudzbenica narudzbenica,
			Roba roba, boolean obrisano) {
		super();
		this.id = id;
		this.jedinicaMere = jedinicaMere;
		this.kolicina = kolicina;
		this.opis = opis;
		this.narudzbenica = narudzbenica;
		this.roba = roba;
		this.obrisano = obrisano;
	}

	public StavkaNarudzbenice() {
		super();
	}

}
