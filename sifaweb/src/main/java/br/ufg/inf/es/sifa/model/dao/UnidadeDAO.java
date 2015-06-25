package br.ufg.inf.es.sifa.model.dao;

import java.util.Iterator;

import br.ufg.inf.es.sifa.model.Unidade;

public class UnidadeDAO extends GenericDAO<Unidade> {
	public UnidadeDAO() {
		super.setClass(Unidade.class);
	}
	
	@Override
	public Unidade buscaPorID(Integer id) {
		for(Iterator<Unidade> it = listaTodos().iterator(); it.hasNext(); ) {
			Unidade unidade = (Unidade) it.next();
			if(unidade.getId() == id) {
				return unidade;
			}
		}
		
		return null;
	}
	
	@Override
	public void removePorID(Integer id) {
		for(Iterator<Unidade> it = listaTodos().iterator(); it.hasNext(); ) {
			Unidade unidade = (Unidade) it.next();
			if(unidade.getId() == id) {
				it.remove();
			}
		}
	}
	
	@Override
	public void atualiza(Unidade unidade) {
		removePorID(unidade.getId());
		insere(unidade);
	}
	
	@Override
	public void insere(Unidade unidade) {
		if (buscaPorID(unidade.getId()) == null) {
			super.insere(unidade);
		} else {
			System.err.println("Já cadastrado!");
		}
		
	}

}
