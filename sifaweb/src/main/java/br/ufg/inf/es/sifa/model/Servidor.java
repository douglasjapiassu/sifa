package br.ufg.inf.es.sifa.model;

import java.util.Date;

public class Servidor extends Pessoa {
	
	public Servidor() {
		// TODO Auto-generated constructor stub
	}

	public Servidor(Integer id, Date dataInsercao, Date dataModificacao, 
			String nome, String matricula, String senha) {
		super(id, dataInsercao, dataModificacao, nome, matricula, senha);
	}

}