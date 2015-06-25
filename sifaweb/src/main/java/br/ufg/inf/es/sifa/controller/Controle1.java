package br.ufg.inf.es.sifa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufg.inf.es.sifa.controller.util.Enumerados;
import br.ufg.inf.es.sifa.controller.util.GeradorPDF;
import br.ufg.inf.es.sifa.model.Processo;
import br.ufg.inf.es.sifa.model.dao.ProcessoDAO;

@SuppressWarnings("unused")
public class Controle1 {
	private long antes;

	private long tempo;
	private GeradorPDF documento = new GeradorPDF();
	public Processo processo;
	public List<Processo> unidade = new ArrayList<Processo>();

	// instancia um objeto do tipo Processo para que este exista e possa
	// ser recebido
	public void cadastrarProcesso(Integer id, String descricao) {
		Date data = new Date();
		processo = new Processo(id, data, descricao);
		ProcessoDAO pDao = new ProcessoDAO();
		pDao.insere(processo);
	}

	// adiciona o processo criado em uma lista para a unidade
	// modifica o status do processo
	public void receberProcesso(Processo processo) {
		unidade.add(processo);
		antes = System.currentTimeMillis();
		processo.setStatus(Enumerados.StatusProcesso.TRABALHO.getCodigo());
	}

	// encaminha o processo para que possa ser recebido em outra unidade
	public void encaminharProcesso(Processo processo) {
		unidade.remove(processo);
		tempo = System.currentTimeMillis() - antes;
		processo.setStatus(Enumerados.StatusProcesso.MOVIMENTO.getCodigo());
	}

	// gera relatório com os dados do processo para conferencia
	public void gerarRelatorio(Processo processo) {
		GeradorPDF geraPdf = new GeradorPDF(processo);
		geraPdf.criarDocumento();
	}
}