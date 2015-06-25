package br.ufg.inf.es.sifa.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class Pessoa extends GenericModel {
	
	private String nome;
	@NotNull @Size(min=5, message="Matrícula deve ter no mínimo 5 caracteres")
	private String matricula;
	@NotNull @Size(min=4, max=8, message="Senha deve ter entre 4 e 8 caracteres")
	private String senha;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer id, Date dataInsercao, Date dataModificacao, String nome, String matricula, String senha) {
		super(id, dataInsercao, dataModificacao);
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matr) {
		this.matricula = matr;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}