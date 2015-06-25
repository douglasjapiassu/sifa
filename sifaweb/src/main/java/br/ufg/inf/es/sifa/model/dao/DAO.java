package br.ufg.inf.es.sifa.model.dao;

import java.util.List;

public interface DAO<T>{

	public void insere(T t);
	public void remove(T t);
	public void removePorID(Integer id);
	public void atualiza(T t);
	public T buscaPorID(Integer id);
	public List<T> listaTodos();
	
}
