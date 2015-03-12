package br.unisinos.jurimobile.model.entity;

public class ProcessoParticipanteAdvogado {

	private Long id;
	private String nome;
	private String numeroOAB;

	public ProcessoParticipanteAdvogado(Long id, String nome, String numeroOAB) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroOAB = numeroOAB;
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

	public String getNumeroOAB() {
		return numeroOAB;
	}

	public void setNumeroOAB(String numeroOAB) {
		this.numeroOAB = numeroOAB;
	}

}
