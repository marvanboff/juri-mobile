package br.unisinos.jurimobile.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ProcessoMovimento {

	private Long id;
	private String dataMovimentacao;
	private String descricao;

	public ProcessoMovimento(Long id, String dataMovimentacao, String descricao) {
		super();
		this.id = id;
		this.dataMovimentacao = dataMovimentacao;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return dataMovimentacao + " - " + descricao;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(String dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public static List<ProcessoMovimento> getMockMovimentacao(boolean reduced) {
		List<ProcessoMovimento> movimentacoes = new ArrayList<ProcessoMovimento>();

		movimentacoes.add(new ProcessoMovimento(1l, "15/05/2012", "PROCESSO DISTRIBUÍDO"));
		movimentacoes.add(new ProcessoMovimento(2l, "17/05/2012", "CONCLUSÃO AO JUIZ"));
		movimentacoes.add(new ProcessoMovimento(3l, "21/05/2012", "AUTOS RETORNADOS AO CARTÓRIO"));
		movimentacoes.add(new ProcessoMovimento(4l, "23/05/2012", "EXPEDIDA CARTA AR/MP"));
		movimentacoes.add(new ProcessoMovimento(5l, "14/06/2012", "CARGA ADVOGADO DO RÉU - 23927/RS"));

		if (reduced) {
			return movimentacoes;
		}

		movimentacoes.add(new ProcessoMovimento(6l, "29/06/2012", "AUTOS COM PETIÇÃO RECEBIDOS NO PROTOCOLO GERAL"));
		movimentacoes.add(new ProcessoMovimento(7l, "02/07/2012", "AUTOS RETORNADOS AO CARTÓRIO"));
		movimentacoes.add(new ProcessoMovimento(8l, "06/07/2012", "EXPEDIDA NOTA DE EXPEDIENTE - 2028/2012 Disponibilizada 09/07/2012"));
		movimentacoes.add(new ProcessoMovimento(9l, "09/07/2012", "DISPONIBILIZADA NOTA NO DJ ELETRÔNICO - 2028/2012 DJE Nº 4869 em 09/07/2012"));
		movimentacoes.add(new ProcessoMovimento(10l, "19/07/2012", "CONCLUSÃO AO JUIZ"));
		movimentacoes.add(new ProcessoMovimento(11l, "25/07/2012", "ORDENADA NOTA DE EXPEDIENTE"));
		movimentacoes.add(new ProcessoMovimento(12l, "25/07/2012", "EXPEDIDA NOTA DE EXPEDIENTE - 2267/2012 Disponibilizada 26/07/2012"));
		movimentacoes.add(new ProcessoMovimento(13l, "26/07/2012", "DISPONIBILIZADA NOTA NO DJ ELETRÔNICO - 2267/2012 DJE Nº 4882 em 26/07/2012"));
		movimentacoes.add(new ProcessoMovimento(14l, "04/09/2012", "CONCLUSÃO AO JUIZ"));
		movimentacoes.add(new ProcessoMovimento(15l, "21/09/2012", "ORDENADA NOTA DE EXPEDIENTE"));
		movimentacoes.add(new ProcessoMovimento(16l, "21/09/2012", "EXPEDIDA NOTA DE EXPEDIENTE - 2935/2012 Disponibilizada 24/09/2012"));
		movimentacoes.add(new ProcessoMovimento(17l, "24/09/2012", "DISPONIBILIZADA NOTA NO DJ ELETRÔNICO - 2935/2012 DJE Nº 4922 em 24/09/2012"));
		movimentacoes.add(new ProcessoMovimento(18l, "24/10/2012", "CUMPRIR DESPACHO"));
		movimentacoes.add(new ProcessoMovimento(19l, "21/01/2013", "CONCLUSÃO AO JUIZ"));
		movimentacoes.add(new ProcessoMovimento(20l, "28/01/2013", "CUMPRIR DESPACHO"));
		movimentacoes.add(new ProcessoMovimento(21l, "28/01/2013", "REMESSA AO MAGISTRADO PARA ASSINATURA"));
		movimentacoes.add(new ProcessoMovimento(22l, "31/01/2013", "ORDENADA NOTA DE EXPEDIENTE"));
		movimentacoes.add(new ProcessoMovimento(23l, "31/01/2013", "EXPEDIDA NOTA DE EXPEDIENTE - 223/2013 Disponibilizada 14/02/2013"));
		movimentacoes.add(new ProcessoMovimento(24l, "14/02/2013", "DISPONIBILIZADA NOTA NO DJ ELETRÔNICO - 223/2013 DJE Nº 5016 em 14/02/2013"));
		movimentacoes.add(new ProcessoMovimento(25l, "02/04/2013", "CONCLUSÃO AO JUIZ"));
		movimentacoes.add(new ProcessoMovimento(26l, "09/04/2013", "ORDENADA NOTA DE EXPEDIENTE"));
		movimentacoes.add(new ProcessoMovimento(27l, "09/04/2013", "EXPEDIDA NOTA DE EXPEDIENTE - 824/2013 Disponibilizada 10/04/2013"));
		movimentacoes.add(new ProcessoMovimento(28l, "10/04/2013", "DISPONIBILIZADA NOTA NO DJ ELETRÔNICO - 824/2013 DJE Nº 5054 em 10/04/2013"));
		movimentacoes.add(new ProcessoMovimento(29l, "14/05/2013", "CONCLUSÃO AO JUIZ"));
		movimentacoes.add(new ProcessoMovimento(30l, "27/05/2013", "EXPEDIDA CARTA PRECATÓRIA"));
		movimentacoes.add(new ProcessoMovimento(31l, "11/09/2013", "DOCUMENTO(S) JUNTADO(S) - Ofício"));
		movimentacoes.add(new ProcessoMovimento(32l, "28/10/2013", "PROCESSO AGUARDANDO JUNTADA"));
		movimentacoes.add(new ProcessoMovimento(33l, "30/01/2014", "JUNTADA PRECATÓRIA INQUIRITÓRIA"));
		movimentacoes.add(new ProcessoMovimento(34l, "30/01/2014", "ORDENADA NOTA DE EXPEDIENTE"));
		movimentacoes.add(new ProcessoMovimento(35l, "30/01/2014", "EXPEDIDA NOTA DE EXPEDIENTE - 152/2014 Disponibilizada 04/02/2014"));
		movimentacoes.add(new ProcessoMovimento(36l, "04/02/2014", "DISPONIBILIZADA NOTA NO DJ ELETRÔNICO - 152/2014 DJE Nº 5253 em 04/02/2014"));
		movimentacoes.add(new ProcessoMovimento(37l, "24/03/2014", "CONCLUSÃO AO JUIZ"));
		movimentacoes.add(new ProcessoMovimento(38l, "22/04/2014", "AUTOS RETORNADOS AO CARTÓRIO"));
		movimentacoes.add(new ProcessoMovimento(39l, "23/04/2014", "ORDENADA NOTA DE EXPEDIENTE"));
		movimentacoes.add(new ProcessoMovimento(40l, "28/04/2014", "EXPEDIDA NOTA DE EXPEDIENTE - 833/2014 Disponibilizada 29/04/2014"));
		movimentacoes.add(new ProcessoMovimento(41l, "29/04/2014", "DISPONIBILIZADA NOTA NO DJ ELETRÔNICO - 833/2014 DJE Nº 5308 em 29/04/2014"));
		movimentacoes.add(new ProcessoMovimento(42l, "12/05/2014", "DOCUMENTO(S) RECEBIDO(S) NO PROTOCOLO GERAL"));
		movimentacoes.add(new ProcessoMovimento(43l, "21/05/2014", "PROCESSO AGUARDANDO JUNTADA"));
		movimentacoes.add(new ProcessoMovimento(44l, "27/06/2014", "DOCUMENTO(S) JUNTADO(S) - Guia"));
		movimentacoes.add(new ProcessoMovimento(45l, "27/06/2014", "JUNTADA PETIÇÃO - RÉU"));
		movimentacoes.add(new ProcessoMovimento(46l, "27/06/2014", "CONCLUSÃO AO JUIZ"));
		movimentacoes.add(new ProcessoMovimento(47l, "02/07/2014", "AUTOS RETORNADOS AO CARTÓRIO"));
		movimentacoes.add(new ProcessoMovimento(48l, "03/07/2014", "SUSPENSÃO DO PROCESSO"));
		movimentacoes.add(new ProcessoMovimento(49l, "15/07/2014", "PROCESSO AGUARDANDO JUNTADA"));
		movimentacoes.add(new ProcessoMovimento(50l, "18/08/2014", "JUNTADO OFÍCIO"));
		movimentacoes.add(new ProcessoMovimento(51l, "18/08/2014", "ORDENADA NOTA DE EXPEDIENTE"));
		movimentacoes.add(new ProcessoMovimento(52l, "23/09/2014", "EXPEDIDA NOTA DE EXPEDIENTE - 1777/2014 Disponibilizada 24/09/2014"));
		movimentacoes.add(new ProcessoMovimento(53l, "24/09/2014", "DISPONIBILIZADA NOTA NO DJ ELETRÔNICO - 1777/2014 DJE Nº 5409 em 24/09/2014"));
		movimentacoes.add(new ProcessoMovimento(54l, "18/11/2014", "REMESSA AO CONTADOR"));
		movimentacoes.add(new ProcessoMovimento(55l, "21/11/2014", "AUTOS RECEBIDOS NA CONTADORIA"));
		movimentacoes.add(new ProcessoMovimento(56l, "28/11/2014", "AUTOS DEVOLVIDOS PELA CONTADORIA"));
		movimentacoes.add(new ProcessoMovimento(57l, "28/11/2014", "AUTOS RETORNADOS AO CARTÓRIO"));
		movimentacoes.add(new ProcessoMovimento(58l, "17/12/2014", "CONCLUSÃO AO JUIZ"));
		movimentacoes.add(new ProcessoMovimento(59l, "28/01/2015", "AUTOS RETORNADOS AO CARTÓRIO - Retornado ao Cartório com Baixa Conclusão"));
		movimentacoes.add(new ProcessoMovimento(60l, "28/01/2015", "ORDENADA NOTA DE EXPEDIENTE"));

		return movimentacoes;

	}

}
