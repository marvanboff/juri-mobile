package br.unisinos.jurimobile.model.entity2;

import java.util.Date;

public class GrupoProcesso implements Auditavel {
	
	private Long id;
	
	private Processo processo;
	
	private Grupo grupo;
	
	private Date dataUltAtualizacao;
	
	
	public GrupoProcesso() {
		super();
	}

	public GrupoProcesso(Long id, Processo processo, Grupo grupo) {
		super();
		this.id = id;
		this.processo = processo;
		this.grupo = grupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Date getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

}
