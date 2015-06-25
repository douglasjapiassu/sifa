package br.ufg.inf.es.sifa.model;

import java.util.Date;

public class Unidade extends GenericModel {
	
	private String nome;
	private String descricao;

	public Unidade() {
		// TODO Auto-generated constructor stub
	}
	
	public Unidade(Integer id, Date dataInsercao, Date dataModificacao,
			String nome, String descricao) {
		super(id, dataInsercao, dataModificacao);
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}