package com.poslovna.Poslovna.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "obrisano='false'")
public class Mesto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String grad;

	@Column(name = "postanski_broj")
	private Long postanskiBroj;

	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "mesto")
	private Set<PoslovniPartner> poslovniPartneri = new HashSet<>();

	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "mesto")
	private Set<Preduzece> preduzeca = new HashSet<>();

	private boolean obrisano;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public Long getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(Long postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public Set<PoslovniPartner> getPoslovniPartneri() {
		return poslovniPartneri;
	}

	public void setPoslovniPartneri(Set<PoslovniPartner> poslovniPartneri) {
		this.poslovniPartneri = poslovniPartneri;
	}

	public Set<Preduzece> getPreduzeca() {
		return preduzeca;
	}

	public void setPreduzeca(Set<Preduzece> preduzeca) {
		this.preduzeca = preduzeca;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public Mesto(Long id, String grad, Long postanskiBroj, Set<PoslovniPartner> poslovniPartneri,
			Set<Preduzece> preduzeca, boolean obrisano) {
		super();
		this.id = id;
		this.grad = grad;
		this.postanskiBroj = postanskiBroj;
		this.poslovniPartneri = poslovniPartneri;
		this.preduzeca = preduzeca;
		this.obrisano = obrisano;
	}

	public Mesto() {
		super();
	}

	
	
	
}
