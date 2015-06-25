package br.ufg.inf.es.sifa.model.builder;

import java.util.Date;
import java.util.Iterator;

import br.ufg.inf.es.sifa.model.Servidor;
import br.ufg.inf.es.sifa.model.dao.ServidorDAO;

public class ServidorBuilder {
	private Integer qtdRegistros;
	
	public ServidorBuilder(Integer qtdRegistros) {
		this.qtdRegistros = qtdRegistros;
		build();
	}
	
	private void build() {
		Integer idProximo = verificaIdUltimoRegistro() + 1;
		for (Integer indice = idProximo; indice <= qtdRegistros + idProximo; indice++) {
			Integer id = indice;
			String nome = "Servidor " + id + ".";
			String matricula = String.valueOf(indice + 100); 
			String senha = String.valueOf(indice + 888);
			Date data = new Date();
			buildServidor(id, data, nome, matricula, senha);
		}
	}
	
	private Servidor buildServidor(Integer idServidor, Date data, String nome, String matricula, String senha) {
		Servidor servidor = new Servidor(idServidor, data, data, nome, matricula, senha);
		ServidorDAO dao = new ServidorDAO();
		dao.insere(servidor);
		
		return servidor;
	}
	
	private Integer verificaIdUltimoRegistro() {
		Integer idServidor = 0;
		ServidorDAO pDao = new ServidorDAO();
		for(Iterator<Servidor> it = pDao.listaTodos().iterator(); it.hasNext(); ) {
			Servidor servidor = (Servidor) it.next();
			if (servidor.getId() > idServidor) {
				idServidor = servidor.getId();
			}
		}
		
		return idServidor;
	}

}
