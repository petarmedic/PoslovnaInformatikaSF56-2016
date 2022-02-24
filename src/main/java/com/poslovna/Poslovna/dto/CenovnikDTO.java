package com.poslovna.Poslovna.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.poslovna.Poslovna.domain.PoslovniPartner;
import com.poslovna.Poslovna.domain.Preduzece;
import com.poslovna.Poslovna.domain.StavkaCenovnika;

public class CenovnikDTO {
	
	private Long Id;

	private Date pocetakRokaTrajanja;

	private Date krajRokaTrajanja;

	private PoslovniPartner poslovniPartner;

	private Preduzece preduzece;

	private Set<StavkaCenovnika> cene = new HashSet<StavkaCenovnika>();

	private boolean obrisano;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getPocetakRokaTrajanja() {
		return pocetakRokaTrajanja;
	}

	public void setPocetakRokaTrajanja(Date pocetakRokaTrajanja) {
		this.pocetakRokaTrajanja = pocetakRokaTrajanja;
	}

	public Date getKrajRokaTrajanja() {
		return krajRokaTrajanja;
	}

	public void setKrajRokaTrajanja(Date krajRokaTrajanja) {
		this.krajRokaTrajanja = krajRokaTrajanja;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Set<StavkaCenovnika> getCene() {
		return cene;
	}

	public void setCene(Set<StavkaCenovnika> cene) {
		this.cene = cene;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public CenovnikDTO(Long id, Date pocetakRokaTrajanja, Date krajRokaTrajanja, PoslovniPartner poslovniPartner,
			Preduzece preduzece, Set<StavkaCenovnika> cene, boolean obrisano) {
		super();
		Id = id;
		this.pocetakRokaTrajanja = pocetakRokaTrajanja;
		this.krajRokaTrajanja = krajRokaTrajanja;
		this.poslovniPartner = poslovniPartner;
		this.preduzece = preduzece;
		this.cene = cene;
		this.obrisano = obrisano;
	}

	public CenovnikDTO() {
		super();
	}

	
}
