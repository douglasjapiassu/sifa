package br.ufg.inf.es.sifa.model;

import java.util.Date;

public class Processo extends GenericModel {
	
	private String descricao;
	private Integer status;
	private Integer idUnidade;
	private Integer idServidor;
	
	public Processo() {
		// TODO Auto-generated constructor stub
	}

	public Processo(Integer id, Date dataInsercao, Date dataModificacao,
			String descricao, Integer status, Integer idUnidade, Integer idServidor) {
		super(id, dataInsercao, dataModificacao);
		this.descricao = descricao;
		this.status = status;
		this.idUnidade = idUnidade;
		this.setIdServidor(idServidor);
	}
	
	public Processo(Integer id, Date data, String descricao) {
		super(id, data, data);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String desc) {
		this.descricao = desc;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(Integer idUnidade) {
		this.idUnidade = idUnidade;
	}

	public Integer getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(Integer idServidor) {
		this.idServidor = idServidor;
	}
}