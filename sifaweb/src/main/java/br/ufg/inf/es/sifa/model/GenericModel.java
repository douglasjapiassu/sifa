package br.ufg.inf.es.sifa.model;

import java.util.Date;

public class GenericModel {

	private Integer id;
	private Date dataInsercao;
	private Date dataModificacao;
	
	public GenericModel() {
		// TODO Auto-generated constructor stub
	}
	
	public GenericModel(Integer id, Date dataInsercao, Date dataModificacao) {
		this.id = id;
		this.dataInsercao = dataInsercao;
		this.dataModificacao = dataModificacao;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
}