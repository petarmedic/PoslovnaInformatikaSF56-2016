package com.poslovna.Poslovna.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Where(clause = "obrisano='false'")
@SQLDelete(sql="UPDATE roba SET obrisano=true Where id=?")
public class Roba {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "naziv_robe")
	private String nazivRobe;

	@Column(name = "jedinica_mere")
	private String jedinicaMere;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "grupa_robe_id")
	private GrupaRobe grupaRobe;

	@OneToMany(mappedBy = "roba", cascade = CascadeType.ALL)
	private Set<StavkaCenovnika> stavkeCenovnika = new HashSet<>();

	@OneToMany(mappedBy = "roba", cascade = CascadeType.ALL)
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

	public Set<StavkaCenovnika> getStavkeCenovnika() {
		return stavkeCenovnika;
	}

	public void setStavkeCenovnika(Set<StavkaCenovnika> stavkeCenovnika) {
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

	public Roba(long id, String nazivRobe, String jedinicaMere, GrupaRobe grupaRobe,
			Set<StavkaCenovnika> stavkeCenovnika, Set<StavkaFakture> stavkeFakture, boolean obrisano) {
		super();
		this.id = id;
		this.nazivRobe = nazivRobe;
		this.jedinicaMere = jedinicaMere;
		this.grupaRobe = grupaRobe;
		this.stavkeCenovnika = stavkeCenovnika;
		this.stavkeFakture = stavkeFakture;
		this.obrisano = obrisano;
	}

	public Roba() {
		super();
	}

}
