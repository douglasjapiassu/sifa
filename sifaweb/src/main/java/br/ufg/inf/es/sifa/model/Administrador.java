package br.ufg.inf.es.sifa.model;

import java.util.Date;

public class Administrador extends Pessoa {
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public Administrador(Integer id, Date dataInsercao, Date dataModificacao,
			String nome, String matricula, String senha) {
		super(id, dataInsercao, dataModificacao, nome, matricula, senha);
	}

	
}