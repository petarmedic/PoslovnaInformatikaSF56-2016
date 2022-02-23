package com.poslovna.Poslovna.dto;

public class MestoDTO {

	private Long id;

	private String grad;

	private Long postanskiBroj;
	
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

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	public MestoDTO(Long id, String grad, Long postanskiBroj, boolean obrisano) {
		super();
		this.id = id;
		this.grad = grad;
		this.postanskiBroj = postanskiBroj;
		this.obrisano = obrisano;
	}

	public MestoDTO() {
		super();
	}
	
	
}
