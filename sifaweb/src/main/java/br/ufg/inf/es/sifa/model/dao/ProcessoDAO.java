package br.ufg.inf.es.sifa.model.dao;

import java.util.Iterator;

import br.ufg.inf.es.sifa.model.Processo;

public class ProcessoDAO extends GenericDAO<Processo> {
	public ProcessoDAO() {
		super.setClass(Processo.class);
	}
	
	@Override
	public Processo buscaPorID(Integer id) {
		for(Iterator<Processo> it = listaTodos().iterator(); it.hasNext(); ) {
			Processo processo = (Processo) it.next();
			if(processo.getId() == id) {
				return processo;
			}
		}
		
		return null;
	}
	
	@Override
	public void removePorID(Integer id) {
		for(Iterator<Processo> it = listaTodos().iterator(); it.hasNext(); ) {
			Processo processo = (Processo) it.next();
			if(processo.getId() == id) {
				it.remove();
			}
		}
	}
	
	@Override
	public void atualiza(Processo processo) {
		removePorID(processo.getId());
		insere(processo);
	}
	
	@Override
	public void insere(Processo processo) {
		if (buscaPorID(processo.getId()) == null) {
			super.insere(processo);
		} else {
			System.err.println("Já cadastrado!");
		}
		
	}

}
