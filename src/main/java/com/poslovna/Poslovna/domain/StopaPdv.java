package com.poslovna.Poslovna.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.Date;
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

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Where(clause = "obrisano='false'")
public class StopaPdv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double procenat;

	@Column(name = "rok_vazenja")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rokVazenja;

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

	public double getProcenat() {
		return procenat;
	}

	public void setProcenat(double procenat) {
		this.procenat = procenat;
	}

	public Date getRokVazenja() {
		return rokVazenja;
	}

	public void setRokVazenja(Date rokVazenja) {
		this.rokVazenja = rokVazenja;
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

	public StopaPdv(long id, double procenat, Date rokVazenja, Pdv pdv, boolean obrisano) {
		super();
		this.id = id;
		this.procenat = procenat;
		this.rokVazenja = rokVazenja;
		this.pdv = pdv;
		this.obrisano = obrisano;
	}

	public StopaPdv() {
		super();
	}

}
