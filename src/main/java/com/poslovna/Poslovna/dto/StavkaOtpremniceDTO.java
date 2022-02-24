package com.poslovna.Poslovna.dto;

public class StavkaOtpremniceDTO {
	
	private long id;

	private String jedinicaMere;

	private int kolicina;

	private String opis;

	private float cena;

	private float ukupanIznos;

	private long otpremnica;

	private long roba;

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

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public float getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(float ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public long getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(long otpremnica) {
		this.otpremnica = otpremnica;
	}

	public long getRoba() {
		return roba;
	}

	public void setRoba(long roba) {
		this.roba = roba;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public StavkaOtpremniceDTO(long id, String jedinicaMere, int kolicina, String opis, float cena, float ukupanIznos,
			long otpremnica, long roba, boolean obrisano) {
		super();
		this.id = id;
		this.jedinicaMere = jedinicaMere;
		this.kolicina = kolicina;
		this.opis = opis;
		this.cena = cena;
		this.ukupanIznos = ukupanIznos;
		this.otpremnica = otpremnica;
		this.roba = roba;
		this.obrisano = obrisano;
	}

	public StavkaOtpremniceDTO() {
		super();
	}
	
	
}
