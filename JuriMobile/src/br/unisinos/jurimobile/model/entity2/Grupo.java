package br.unisinos.jurimobile.model.entity2;

import java.util.Date;

public class Grupo implements Auditavel {
	
	private Long id;
	
	private String nome;
	
	private Date dataUltAtualizacao;
	
	public Grupo() {
		super();
	}

	public Grupo(Long id, String nome) {
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

	public Date getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}
}
