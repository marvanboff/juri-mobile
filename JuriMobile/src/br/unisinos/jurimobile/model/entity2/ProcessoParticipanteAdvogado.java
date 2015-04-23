package br.unisinos.jurimobile.model.entity2;

import java.util.Date;

public class ProcessoParticipanteAdvogado implements Auditavel {

	private Long id;

	private ProcessoParticipante participante;
	
	private Advogado advogado;

	private Date dataUltAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProcessoParticipante getParticipante() {
		return participante;
	}

	public void setParticipante(ProcessoParticipante participante) {
		this.participante = participante;
	}

	public Date getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}
	
}
