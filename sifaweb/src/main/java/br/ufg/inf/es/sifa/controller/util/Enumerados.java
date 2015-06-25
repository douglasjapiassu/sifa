package br.ufg.inf.es.sifa.controller.util;

public class Enumerados {
	
	public enum StatusProcesso {
		RECEBIDO(1, "Recebido na unidade"),
		ENCAMINHADO(2, "Encaminhado para a unidade"),
		TRABALHO(3, "Processo em trabalho"),
		MOVIMENTO(4, "Processo em movimento");
		
		
		private Integer codigo;
		private String descricao;
		
		StatusProcesso(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}
		
		public Integer getCodigo() {
			return codigo;
		}
		
		public String getDescricao() {
			return descricao;
		}
	}

}
