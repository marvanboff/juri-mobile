package br.unisinos.jurimobile.model.entity.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessoMock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String TABELA = "processo_mock";
	public static final String _ID = "_id";
	public static final String NUMERO = "numero";
	
	private Long id;

	private String numero;

	private String assunto;

	private String situacao;

	private String comarca;

	private String orgaoJulgador;

	private Date dataDistribuicao;

	private List<ProcessoParticipanteMock> participantes;

	private List<ProcessoMovimentoMock> movimentacoes;

	public ProcessoMock(){
		
	}
	
	public ProcessoMock(Long id, String numero){
		this.id = id;
		this.numero = numero;
	}
	
	public ProcessoMock(Long id, String numero, String assunto, String orgaoJulgador, String comarca, String situacao) {
		super();
		this.id = id;
		this.numero = numero;
		this.assunto = assunto;
		this.orgaoJulgador = orgaoJulgador;
		this.comarca = comarca;
		this.situacao = situacao;
	}
	
	public String getNomesParticipantes(){
		StringBuilder nomes = new StringBuilder();
		if(participantes != null){
			for (ProcessoParticipanteMock participante : participantes) {
				if(nomes.length() > 0){
					nomes.append(", ");
				}
				nomes.append(participante.getNome());
			}
		}
		return nomes.toString();
	}
	
	public void addParticipante(ProcessoParticipanteMock processoParticipanteMock){
		if(participantes == null){
			participantes = new ArrayList<ProcessoParticipanteMock>();
		}
		participantes.add(processoParticipanteMock);
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getComarca() {
		return comarca;
	}

	public void setComarca(String comarca) {
		this.comarca = comarca;
	}

	public String getOrgaoJulgador() {
		return orgaoJulgador;
	}

	public void setOrgaoJulgador(String orgaoJulgador) {
		this.orgaoJulgador = orgaoJulgador;
	}

	public Date getDataDistribuicao() {
		return dataDistribuicao;
	}

	public void setDataDistribuicao(Date dataDistribuicao) {
		this.dataDistribuicao = dataDistribuicao;
	}

	public List<ProcessoParticipanteMock> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<ProcessoParticipanteMock> participantes) {
		this.participantes = participantes;
	}

	public List<ProcessoMovimentoMock> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<ProcessoMovimentoMock> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}
