package br.ufg.inf.es.sifa.model;

import java.util.Date;

public class Diretor extends Pessoa{
	
	public Diretor() {
		// TODO Auto-generated constructor stub
	}

	public Diretor(Integer id, Date dataInsercao, Date dataModificacao,
			String nome, String matricula, String senha) {
		super(id, dataInsercao, dataModificacao, nome, matricula, senha);
	}
	
}