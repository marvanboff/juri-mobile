package br.unisinos.jurimobile.model.entity.mock;

import java.util.List;

import br.unisinos.jurimobile.model.entity.TipoParticipante;

public class ProcessoParticipanteMock {

	private Long id;

	private String nome;

	private String tipoParticipacao;

	private TipoParticipante tipoParticipante;

	private ProcessoMock processo;
	
	private List<ProcessoParticipanteAdvogadoMock> advogados;

	public ProcessoParticipanteMock(Long id, String nome, String tipoParticipacao, TipoParticipante tipoParticipante) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoParticipacao = tipoParticipacao;
		this.tipoParticipante = tipoParticipante;
	}

	public List<ProcessoParticipanteAdvogadoMock> getAdvogados() {
		return advogados;
	}

	public void setAdvogados(List<ProcessoParticipanteAdvogadoMock> advogados) {
		this.advogados = advogados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoParticipacao() {
		return tipoParticipacao;
	}

	public void setTipoParticipacao(String tipoParticipacao) {
		this.tipoParticipacao = tipoParticipacao;
	}

	public TipoParticipante getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(TipoParticipante tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

	public ProcessoMock getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoMock processo) {
		this.processo = processo;
	}

}