package br.unisinos.jurimobile.model.entity2;

import java.util.Date;
import java.util.List;

public class Usuario implements Auditavel {

	private Long id;
	
	private String login;
	
	private String nome;
	
	private List<Processo> processos;
	
	private Date dataUltAtualizacao;
	
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

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public Date getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
