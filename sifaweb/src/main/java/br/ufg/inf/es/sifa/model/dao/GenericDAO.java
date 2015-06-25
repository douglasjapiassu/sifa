package br.ufg.inf.es.sifa.model.dao;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class GenericDAO<T> implements DAO<T> {
	private List list;
	
	public void setClass(Class clazz) {
		PersistenceStrategy strategy = new FilePersistenceStrategy(getCaminho(clazz));
		list = new XmlArrayList(strategy); 
	}

	public void insere(T t) {
		list.add(t);
	}

	public void remove(T t) {
		for(Iterator<T> it = list.iterator(); it.hasNext(); ) {
			T t2 = (T) it.next();
			if(t2 == t) {
				it.remove();
			}
		}
	}
	
	public void removePorID(Integer id) {
		
	}

	public void atualiza(T t) {
		
	}

	public T buscaPorID(Integer id) {
		return null;
	}

	public List<T> listaTodos() {
		return list;
	}
	
	private File getCaminho(Class clazz) {
		String nomeDiretorio = clazz.getSimpleName();
		String fs = System.getProperty("file.separator");
		File caminho = new File("src" + fs + "main" + fs + "resources" + fs + nomeDiretorio);
		
		if (!caminho.exists()) {
			caminho.mkdirs();
		}
		
		return caminho;
	}
	
	

}
