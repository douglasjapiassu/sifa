package br.ufg.inf.es.sifa.model.builder;

import java.util.Date;
import java.util.Iterator;

import br.ufg.inf.es.sifa.model.Unidade;
import br.ufg.inf.es.sifa.model.dao.UnidadeDAO;

public class UnidadeBuilder {
	private Integer qtdRegistros;
	
	public UnidadeBuilder(Integer qtdRegistros) {
		this.qtdRegistros = qtdRegistros;
		build();
	}
	
	private void build() {
		Integer idProximo = verificaIdUltimoRegistro() + 1;
		for (Integer indice = idProximo; indice <= qtdRegistros + idProximo; indice++) {
			Integer id = indice;
			String nome = "Unidade " + id + ".";
			String descricao = "Descrição " + nome; 
			Date data = new Date();
			buildUnidade(id, data, nome, descricao);
		}
	}
	
	private Unidade buildUnidade(Integer idUnidade, Date data, String nome, String descricao) {
		Unidade unidade = new Unidade(idUnidade, data, data, nome, descricao);
		UnidadeDAO dao = new UnidadeDAO();
		dao.insere(unidade);
		
		return unidade;
	}
	
	private Integer verificaIdUltimoRegistro() {
		Integer idUnidade = 0;
		UnidadeDAO pDao = new UnidadeDAO();
		for(Iterator<Unidade> it = pDao.listaTodos().iterator(); it.hasNext(); ) {
			Unidade unidade = (Unidade) it.next();
			if (unidade.getId() > idUnidade) {
				idUnidade = unidade.getId();
			}
		}
		
		return idUnidade;
	}

}
