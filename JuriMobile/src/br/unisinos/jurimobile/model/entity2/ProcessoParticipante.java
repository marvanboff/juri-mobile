package br.unisinos.jurimobile.model.entity2;

import java.util.Date;
import java.util.List;

import br.unisinos.jurimobile.model.entity.TipoParticipante;

public class ProcessoParticipante implements Auditavel {

	private Long id;

	private String nome;

	private String tipoParticipacao;

	private TipoParticipante tipoParticipante;

	private Processo processo;

	private List<ProcessoParticipanteAdvogado> advogados;

	private Date dataUltAtualizacao;

	public List<ProcessoParticipanteAdvogado> getAdvogados() {
		return advogados;
	}

	public void setAdvogados(List<ProcessoParticipanteAdvogado> advogados) {
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

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Date getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

}
