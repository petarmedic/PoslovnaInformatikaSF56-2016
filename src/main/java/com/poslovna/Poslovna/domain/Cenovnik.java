package com.poslovna.Poslovna.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "obrisano='false'")
public class Cenovnik {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "pocetak_roka_trajanja")
	private Date pocetakRokaTrajanja;

	@Column(name = "kraj_roka_trajanja")
	private Date krajRokaTrajanja;

	@ManyToOne
	@JoinColumn(name = "poslovni_partner_id", nullable = true)
	private PoslovniPartner poslovniPartner;

	@ManyToOne
	@JoinColumn(name = "preduzece_id", nullable = true)
	private Preduzece preduzece;

	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "cenovnik")
	private Set<StavkeCenovnika> cene = new HashSet<StavkeCenovnika>();

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

	public Set<StavkeCenovnika> getCene() {
		return cene;
	}

	public void setCene(Set<StavkeCenovnika> cene) {
		this.cene = cene;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public Cenovnik(Long id, Date pocetakRokaTrajanja, Date krajRokaTrajanja, PoslovniPartner poslovniPartner,
			Preduzece preduzece, Set<StavkeCenovnika> cene, boolean obrisano) {
		super();
		Id = id;
		this.pocetakRokaTrajanja = pocetakRokaTrajanja;
		this.krajRokaTrajanja = krajRokaTrajanja;
		this.poslovniPartner = poslovniPartner;
		this.preduzece = preduzece;
		this.cene = cene;
		this.obrisano = obrisano;
	}

	public Cenovnik() {
		super();
	}

	
	
	
	
}
