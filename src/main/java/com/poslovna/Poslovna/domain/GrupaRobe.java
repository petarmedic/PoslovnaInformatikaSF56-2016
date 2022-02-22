package com.poslovna.Poslovna.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
public class GrupaRobe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String naziv;

	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "grupaRobe")
	private Set<Roba> robe = new HashSet<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "preduzece_id")
	private Preduzece preduzece;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pdv_id")
	private Pdv pdv;

	private boolean obrisano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Roba> getRobe() {
		return robe;
	}

	public void setRobe(Set<Roba> robe) {
		this.robe = robe;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Pdv getPdv() {
		return pdv;
	}

	public void setPdv(Pdv pdv) {
		this.pdv = pdv;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public GrupaRobe(long id, String naziv, Set<Roba> robe, Preduzece preduzece, Pdv pdv, boolean obrisano) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.robe = robe;
		this.preduzece = preduzece;
		this.pdv = pdv;
		this.obrisano = obrisano;
	}

	public GrupaRobe() {
		super();
	}
	
	
}
