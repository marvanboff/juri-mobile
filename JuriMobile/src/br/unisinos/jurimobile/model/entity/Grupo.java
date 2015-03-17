package br.unisinos.jurimobile.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

	private Long id;
	private String nome;
	private List<Processo> processos;

	public Grupo() {
		super();
	}

	public Grupo(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public boolean addProcesso(Processo processo){
		if(processos == null){
			processos = new ArrayList<Processo>();
		}
		return processos.add(processo);
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

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}
}
