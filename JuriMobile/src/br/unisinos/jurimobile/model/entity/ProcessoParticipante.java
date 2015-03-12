package br.unisinos.jurimobile.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ProcessoParticipante {

	private Long id;
	private String nome;
	private String tipoParticipacao;
	private TipoParticipante tipoParticipante;
	private List<ProcessoParticipanteAdvogado> advogados; 
	
	public ProcessoParticipante() {
		super();
	}

	public ProcessoParticipante(Long id, String nome, String tipoParticipacao, TipoParticipante tipoParticipante) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoParticipacao = tipoParticipacao;
		this.tipoParticipante = tipoParticipante;
	}
	
	public boolean addAdvogado(ProcessoParticipanteAdvogado advogado){
		if(advogados == null){
			advogados = new ArrayList<ProcessoParticipanteAdvogado>();
		}
		return advogados.add(advogado);
	}
	
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
	
}
