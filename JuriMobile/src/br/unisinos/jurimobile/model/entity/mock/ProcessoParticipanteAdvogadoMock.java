package br.unisinos.jurimobile.model.entity.mock;


public class ProcessoParticipanteAdvogadoMock {

	private Long id;

	private ProcessoParticipanteMock participante;

	private AdvogadoMock advogado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProcessoParticipanteMock getParticipante() {
		return participante;
	}

	public void setParticipante(ProcessoParticipanteMock participante) {
		this.participante = participante;
	}

	public AdvogadoMock getAdvogado() {
		return advogado;
	}

	public void setAdvogado(AdvogadoMock advogado) {
		this.advogado = advogado;
	}
	
}
