package br.unisinos.jurimobile.model.entity.mock;


public class ProcessoParticipanteAdvogadoMock {

	private Long id;

	private Long idParticipante;

	private AdvogadoMock advogado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}

	public AdvogadoMock getAdvogado() {
		return advogado;
	}

	public void setAdvogado(AdvogadoMock advogado) {
		this.advogado = advogado;
	}
	
}
