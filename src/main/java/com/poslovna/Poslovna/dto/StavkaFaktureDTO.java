package com.poslovna.Poslovna.dto;

import com.poslovna.Poslovna.domain.Faktura;
import com.poslovna.Poslovna.domain.Roba;

public class StavkaFaktureDTO {
	
	private long id;

	private double cena;

	private long kolicina;

	private double osnovicaPDV;

	private double procenatPDV;

	private double iznosPDV;

	private double rabat;

	private double ukupanIznos;

	private Roba roba;

	private Faktura faktura;

	private boolean obrisano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public long getKolicina() {
		return kolicina;
	}

	public void setKolicina(long kolicina) {
		this.kolicina = kolicina;
	}

	public double getOsnovicaPDV() {
		return osnovicaPDV;
	}

	public void setOsnovicaPDV(double osnovicaPDV) {
		this.osnovicaPDV = osnovicaPDV;
	}

	public double getProcenatPDV() {
		return procenatPDV;
	}

	public void setProcenatPDV(double procenatPDV) {
		this.procenatPDV = procenatPDV;
	}

	public double getIznosPDV() {
		return iznosPDV;
	}

	public void setIznosPDV(double iznosPDV) {
		this.iznosPDV = iznosPDV;
	}

	public double getRabat() {
		return rabat;
	}

	public void setRabat(double rabat) {
		this.rabat = rabat;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public Roba getRoba() {
		return roba;
	}

	public void setRoba(Roba roba) {
		this.roba = roba;
	}

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public StavkaFaktureDTO(long id, double cena, long kolicina, double osnovicaPDV, double procenatPDV,
			double iznosPDV, double rabat, double ukupanIznos, Roba roba, Faktura faktura, boolean obrisano) {
		super();
		this.id = id;
		this.cena = cena;
		this.kolicina = kolicina;
		this.osnovicaPDV = osnovicaPDV;
		this.procenatPDV = procenatPDV;
		this.iznosPDV = iznosPDV;
		this.rabat = rabat;
		this.ukupanIznos = ukupanIznos;
		this.roba = roba;
		this.faktura = faktura;
		this.obrisano = obrisano;
	}

	public StavkaFaktureDTO() {
		super();
	}
	
	
	
}
