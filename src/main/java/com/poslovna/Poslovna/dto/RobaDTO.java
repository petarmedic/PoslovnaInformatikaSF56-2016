package com.poslovna.Poslovna.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poslovna.Poslovna.domain.GrupaRobe;
import com.poslovna.Poslovna.domain.StavkaFakture;
import com.poslovna.Poslovna.domain.StavkeCenovnika;

public class RobaDTO {

	private long id;

	private String nazivRobe;

	private String jedinicaMere;
	@JsonIgnore
	private GrupaRobe grupaRobe;
	@JsonIgnore
	private Set<StavkeCenovnika> stavkeCenovnika = new HashSet<>();
	@JsonIgnore
	private Set<StavkaFakture> stavkeFakture = new HashSet<>();

	private boolean obrisano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazivRobe() {
		return nazivRobe;
	}

	public void setNazivRobe(String nazivRobe) {
		this.nazivRobe = nazivRobe;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public GrupaRobe getGrupaRobe() {
		return grupaRobe;
	}

	public void setGrupaRobe(GrupaRobe grupaRobe) {
		this.grupaRobe = grupaRobe;
	}

	public Set<StavkeCenovnika> getStavkeCenovnika() {
		return stavkeCenovnika;
	}

	public void setStavkeCenovnika(Set<StavkeCenovnika> stavkeCenovnika) {
		this.stavkeCenovnika = stavkeCenovnika;
	}

	public Set<StavkaFakture> getStavkeFakture() {
		return stavkeFakture;
	}

	public void setStavkeFakture(Set<StavkaFakture> stavkeFakture) {
		this.stavkeFakture = stavkeFakture;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public RobaDTO(long id, String nazivRobe, String jedinicaMere, GrupaRobe grupaRobe,
			Set<StavkeCenovnika> stavkeCenovnika, Set<StavkaFakture> stavkeFakture, boolean obrisano) {
		super();
		this.id = id;
		this.nazivRobe = nazivRobe;
		this.jedinicaMere = jedinicaMere;
		this.grupaRobe = grupaRobe;
		this.stavkeCenovnika = stavkeCenovnika;
		this.stavkeFakture = stavkeFakture;
		this.obrisano = obrisano;
	}

	public RobaDTO() {
		super();
	}

}
