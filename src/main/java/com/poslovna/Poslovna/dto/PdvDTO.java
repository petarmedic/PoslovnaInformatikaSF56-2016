package com.poslovna.Poslovna.dto;

import java.util.HashSet;
import java.util.Set;

import com.poslovna.Poslovna.domain.GrupaRobe;
import com.poslovna.Poslovna.domain.StopaPdv;

public class PdvDTO {

	private long id;

	private String vrstaPdv;

	private Set<StopaPdv> stopePdv = new HashSet<>();

	private Set<GrupaRobe> grupeRobe = new HashSet<>();

	private boolean obrisano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVrstaPdv() {
		return vrstaPdv;
	}

	public void setVrstaPdv(String vrstaPdv) {
		this.vrstaPdv = vrstaPdv;
	}

	public Set<StopaPdv> getStopePdv() {
		return stopePdv;
	}

	public void setStopePdv(Set<StopaPdv> stopePdv) {
		this.stopePdv = stopePdv;
	}

	public Set<GrupaRobe> getGrupeRobe() {
		return grupeRobe;
	}

	public void setGrupeRobe(Set<GrupaRobe> grupeRobe) {
		this.grupeRobe = grupeRobe;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public PdvDTO(long id, String vrstaPdv, Set<StopaPdv> stopePdv, Set<GrupaRobe> grupeRobe, boolean obrisano) {
		super();
		this.id = id;
		this.vrstaPdv = vrstaPdv;
		this.stopePdv = stopePdv;
		this.grupeRobe = grupeRobe;
		this.obrisano = obrisano;
	}

	public PdvDTO() {
		super();
	}

}
