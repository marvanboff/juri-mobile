package br.unisinos.jurimobile.model.entity;

public class ProcessoParticipante {

	private Long id;
	private String nome;

	public ProcessoParticipante() {
		super();
	}

	public ProcessoParticipante(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

}
