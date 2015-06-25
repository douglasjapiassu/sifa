package br.ufg.inf.es.sifa.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ValidModel {
	
	private Long id;
	
	@NotNull @Size(min=5)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
