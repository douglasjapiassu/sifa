package br.ufg.inf.es.sifa.model.builder;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import br.ufg.inf.es.sifa.model.Processo;
import br.ufg.inf.es.sifa.model.dao.ProcessoDAO;

public class ProcessoBuilder {
	private Integer qtdRegistros;
	private Integer idUnidade;
	
	public ProcessoBuilder(Integer qtdRegistros, Integer idUnidade) {
		this.qtdRegistros = qtdRegistros;
		this.idUnidade = idUnidade;
		build();
	}
	
	private void build() {
		Integer idProximo = verificaIdUltimoRegistro() + 1;
		Random rdm = new Random(4);
		Integer status = 0;
		Integer servidor = 0;
		for (Integer indice = idProximo; indice <= qtdRegistros + idProximo; indice++) {
			Integer id = indice;
			String descricao = "Descrição do processo " + id + ".";
			status = rdm.nextInt();
			servidor = rdm.nextInt();
			Date data = new Date();
			buildProcesso(id, descricao, status, data, servidor);
		}
	}
	
	private Processo buildProcesso(Integer id, String descricao, Integer status, Date data, Integer idServidor) {
		Processo processo = new Processo(id, data, data, descricao, status, idUnidade, idServidor);
		ProcessoDAO dao = new ProcessoDAO();
		dao.insere(processo);
		
		return processo;
	}
	
	private Integer verificaIdUltimoRegistro() {
		Integer idProcesso = 0;
		ProcessoDAO pDao = new ProcessoDAO();
		for(Iterator<Processo> it = pDao.listaTodos().iterator(); it.hasNext(); ) {
			Processo processo = (Processo) it.next();
			if (processo.getId() > idProcesso) {
				idProcesso = processo.getId();
			}
		}
		
		return idProcesso;
	}

}
