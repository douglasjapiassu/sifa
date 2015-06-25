package br.ufg.inf.es.sifa.model.dao;

import java.util.Iterator;

import br.ufg.inf.es.sifa.model.Servidor;

public class ServidorDAO extends GenericDAO<Servidor> {
	public ServidorDAO() {
		super.setClass(Servidor.class);
	}
	
	@Override
	public Servidor buscaPorID(Integer id) {
		for(Iterator<Servidor> it = listaTodos().iterator(); it.hasNext(); ) {
			Servidor servidor = (Servidor) it.next();
			if(servidor.getId() == id) {
				return servidor;
			}
		}
		
		return null;
	}
	
	@Override
	public void removePorID(Integer id) {
		for(Iterator<Servidor> it = listaTodos().iterator(); it.hasNext(); ) {
			Servidor servidor = (Servidor) it.next();
			if(servidor.getId() == id) {
				it.remove();
			}
		}
	}
	
	@Override
	public void atualiza(Servidor servidor) {
		removePorID(servidor.getId());
		insere(servidor);
	}
	
	@Override
	public void insere(Servidor servidor) {
		if (buscaPorID(servidor.getId()) == null) {
			super.insere(servidor);
		} else {
			System.err.println("Já cadastrado!");
		}
		
	}

}
