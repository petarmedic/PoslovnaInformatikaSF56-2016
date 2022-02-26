package com.poslovna.Poslovna.dto;

public class StavkaNarudzbeniceDTO {
	
	private long id;

	private String jedinicaMere;

	private int kolicina;

	private String opis;
	
	private long narudzbenica;
	
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

	public long getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(long narudzbenica) {
		this.narudzbenica = narudzbenica;
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

	public StavkaNarudzbeniceDTO(long id, String jedinicaMere, int kolicina, String opis, long narudzbenica, long roba,
			boolean obrisano) {
		super();
		this.id = id;
		this.jedinicaMere = jedinicaMere;
		this.kolicina = kolicina;
		this.opis = opis;
		this.narudzbenica = narudzbenica;
		this.roba = roba;
		this.obrisano = obrisano;
	}

	public StavkaNarudzbeniceDTO() {
		super();
	}
	
	
}
